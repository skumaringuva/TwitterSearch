package com.sheshu.twittersearch.controller;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;

import com.sheshu.twittersearch.BuildConfig;
import com.sheshu.twittersearch.model.AuthenticationPreferences;
import com.sheshu.twittersearch.web.Tweets;
import com.sheshu.twittersearch.web.TwitterApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sheshu on 8/6/17.
 */
public class TwitterController implements Callback<Tweets> {
    public static final int SEARCH_TYPE_NORMAL = 0;
    public static final int SEARCH_TYPE_EXACT = 1;
    public static final int SEARCH_TYPE_OR = 2;
    public static final int SEARCH_TYPE_NOT_KEYWORD = 3;
    public static final int SEARCH_TYPE_HASH_TAG = 4; // like normal
    public static final int SEARCH_TYPE_FROM_ACCOUNT = 5;
    public static final int SEARCH_TYPE_FROM_LIST = 6;
    public static final int SEARCH_TYPE_TO_ACCOUNT = 7;
    public static final int SEARCH_TYPE_MENTION_ACCOUNT = 8;
    public static final int SEARCH_TYPE_FILTER_SAFE = 9;
    public static final int SEARCH_TYPE_FILTER_MEDIA = 10;
    public static final int SEARCH_TYPE_FILTER_NATIVE_VIDEO = 11;
    public static final int SEARCH_TYPE_FILTER_NO_RETWEETS = 12;
    public static final int SEARCH_TYPE_FILTER_PERISCOPE = 13;
    public static final int SEARCH_TYPE_FILTER_VINE = 14;
    public static final int SEARCH_TYPE_FILTER_IMAGES = 15;
    public static final int SEARCH_TYPE_FILTER_TWIMG = 16;
    public static final int SEARCH_TYPE_FILTER_LINKS = 17;
    public static final int SEARCH_TYPE_URL_KEYWORD = 18;
    public static final int SEARCH_TYPE_FILTER_SINCE = 19;
    public static final int SEARCH_TYPE_FILTER_UNTIL = 20;
    public static final int SEARCH_TYPE_FILTER_NO_SCARY = 21; // -
    public static final int SEARCH_TYPE_FILTER_POSITIVE_ATTITUDE = 22;
    public static final int SEARCH_TYPE_FILTER_NEGATIVE_ATTITUDE = 23;
    public static final int SEARCH_TYPE_FILTER_NEGATIVE_QUESTION = 24;
    private static final String TWITTER_BASE_URL = "https://api.twitter.com";
    private static final String TWITTER_TOKEN_URL = TWITTER_BASE_URL + "/oauth2/token";
    private static final String TAG = "TwitterController";
    private static String mBearerToken;
    private static String mTokenType;
    private final Context mConext;
    private TwitterNotifier mNotifier;

    public TwitterController(Context context) {
        mConext = context;
    }

    public static String addKeyword(int type, String arg1) {
        String keyword = null;
        switch (type) {
            case SEARCH_TYPE_NORMAL:
                keyword = arg1;
                break;
            case SEARCH_TYPE_EXACT:
                keyword = "\"" + arg1 + "\"";
                break;
            case SEARCH_TYPE_OR:
                keyword = "OR" + arg1;
                break;
            case SEARCH_TYPE_NOT_KEYWORD:
                keyword = "-" + arg1;
                break; //
            case SEARCH_TYPE_HASH_TAG:   // IDENTIFY PREFIX #
                keyword = arg1; // it is same as normal search with #keyword
                break;
            case SEARCH_TYPE_FROM_ACCOUNT:
                keyword = "from:" + arg1;
                break;
            case SEARCH_TYPE_FROM_LIST:
                keyword = "list:" + arg1;
                break;
            case SEARCH_TYPE_TO_ACCOUNT:
                keyword = "to:" + arg1;
                break;
            case SEARCH_TYPE_MENTION_ACCOUNT:
                keyword = arg1; // user will append @
                break;
            case SEARCH_TYPE_FILTER_SAFE:
                keyword = "filter:safe";
                break;
            case SEARCH_TYPE_FILTER_MEDIA:
                keyword = "filter:media";
                break;
            case SEARCH_TYPE_FILTER_NATIVE_VIDEO:
                keyword = "filter:native_video";
                break;
            case SEARCH_TYPE_FILTER_NO_RETWEETS:
                keyword = "-filter:retweets";
                break;
            case SEARCH_TYPE_FILTER_PERISCOPE:
                keyword = "filter:periscope";
                break;
            case SEARCH_TYPE_FILTER_VINE:
                keyword = "filter:vine";
                break;
            case SEARCH_TYPE_FILTER_IMAGES:
                keyword = "filter:images";
                break;
            case SEARCH_TYPE_FILTER_TWIMG:
                keyword = "filter:twimg";
                break;
            case SEARCH_TYPE_FILTER_LINKS:
                keyword = "filter:links";
                break;
            case SEARCH_TYPE_URL_KEYWORD:
                keyword = "url:" + arg1;
                break;
            case SEARCH_TYPE_FILTER_SINCE:
                keyword = "since:" + arg1;
                break;
            case SEARCH_TYPE_FILTER_UNTIL:
                keyword = "until:" + arg1;
                break;
            case SEARCH_TYPE_FILTER_NO_SCARY:
                keyword = "-scary";
                break;
            case SEARCH_TYPE_FILTER_POSITIVE_ATTITUDE:
                keyword = ":)";
                break;
            case SEARCH_TYPE_FILTER_NEGATIVE_ATTITUDE:
                keyword = ":(";
                break;
            case SEARCH_TYPE_FILTER_NEGATIVE_QUESTION:
                keyword = arg1; // user will add a question mark.
                break;
        }
        return keyword;
    }

    public void login(TwitterNotifier notifier) {
        mNotifier = notifier;
        // check if we can get the info from preferences.
        getSavedAuthenticationInformation();
        if (TextUtils.isEmpty(mTokenType) || TextUtils.isEmpty((mBearerToken))) {
            AuthenticationAsyncTask authTask = new AuthenticationAsyncTask();
            authTask.execute();
        } else {
            notifyListener();
        }
    }

    public void searchTwitter(SparseArray<String> params) {
        StringBuilder searchKey = new StringBuilder();
        for (int index = 0; index < params.size(); index++) {
            if (searchKey.length() != 0) {
                searchKey.append(" ");
            }
            searchKey.append(params.valueAt(index));
        }
        String searchKeyUrlEncoded = null;
        try {
            searchKeyUrlEncoded = URLEncoder.encode(searchKey.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(searchKeyUrlEncoded)) {
            mNotifier.searchError();
        } else {
            Log.e(TAG, "Search keyword: " + searchKey.toString());
        }
        final String token = mTokenType + " "
                + mBearerToken;
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TWITTER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        // prepare call in Retrofit 2.0
        TwitterApi api = retrofit.create(TwitterApi.class);
        Call<Tweets> call = api.getSearchResults(token, searchKey.toString());
        //asynchronous call
        call.enqueue(this);
    }

    private void notifyListener() {
        if (mNotifier != null) {
            if (!TextUtils.isEmpty(mTokenType) && !TextUtils.isEmpty((mBearerToken))) {
                mNotifier.onAuthenticated(true);
            } else
                mNotifier.onAuthenticated(false);
        }
    }

    private void saveAuthenticationInformation() {
        AuthenticationPreferences.setAuthType(mConext, mTokenType);
        AuthenticationPreferences.setBearerToken(mConext, mBearerToken);
    }

    private void getSavedAuthenticationInformation() {
        // fetch from preferences, if values are null.
        if (TextUtils.isEmpty(mTokenType) || TextUtils.isEmpty((mBearerToken))) {
            mTokenType = AuthenticationPreferences.getAuthType(mConext);
            mBearerToken = AuthenticationPreferences.getBearerToken(mConext);
        }
    }
    // Retrofit callbacks

    @Override
    public void onFailure(Call<Tweets> call, Throwable t) {
        mNotifier.searchError();
        t.printStackTrace();
    }

    @Override
    public void onResponse(@NonNull Call<Tweets> call, @NonNull final retrofit2.Response<Tweets> response) {
        //noinspection ConstantConditions
        if ((null != response.body()) && response.isSuccessful()
                && response.body().getStatuses() != null) {
            Log.v(TAG, response.message() + response.toString() + response.body().getStatuses().toString());
            mNotifier.searchResults(response.body().getStatuses());
        } else {
            mNotifier.searchError();
        }
    }
    // Retrofit callbacks.
    //https://stackoverflow.com/questions/43322107/how-to-add-parameters-to-httprequest-in-order-to-work-with-twitter-api-1-1

    private class AuthenticationAsyncTask extends AsyncTask<String, Void, Void> {
        private static final String CONSUMER_KEY = BuildConfig.CONSUMER_KEY;
        private static final String CONSUMER_SECRET = BuildConfig.CONSUMER_SECRET;
        boolean finished;
        private String returnEntry;

        public void sendPostRequestToGetBearerToken() {
            URL loc = null;
            HttpsURLConnection conn = null;
            InputStreamReader is;
            BufferedReader in;
            try {
                loc = new URL(TWITTER_TOKEN_URL);
            } catch (MalformedURLException ex) {
                return;
            }
            try {
                String urlApiKey = URLEncoder.encode(CONSUMER_KEY, "UTF-8");
                String urlApiSecret = URLEncoder.encode(CONSUMER_SECRET, "UTF-8");
                String combined = urlApiKey + ":" + urlApiSecret;
                byte[] data = combined.getBytes();
                String base64 = Base64.encodeToString(data, Base64.NO_WRAP);
                conn = (HttpsURLConnection) loc.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Host", "api.twitter.com");
                // conn.setRequestProperty("User-Agent", "TwitterSearchSheshu");
                conn.setRequestProperty("Authorization", "Basic " + base64);
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
                conn.setRequestProperty("Content-Length", "29");
                conn.setRequestProperty("User-Agent", "Mozilla/5.0 ( compatible ) ");
                conn.setRequestProperty("Accept", "*/*");
                conn.setUseCaches(false);
                String urlParameters = "grant_type=client_credentials";
                DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
                wr.writeBytes(urlParameters);
                wr.flush();
                wr.close();
                int status = conn.getResponseCode();
                if (status == HttpsURLConnection.HTTP_OK) {
                    is = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    in = new BufferedReader(is);
                    readResponse(in);
                    setJSONresults();
                } else {
                    Log.e(TAG, conn.getResponseMessage());
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                if (conn != null)
                    conn.disconnect();
            }
        }

        public void readResponse(BufferedReader in) {
            String tmp = "";
            StringBuilder response = new StringBuilder();
            do {
                try {
                    tmp = in.readLine();
                } catch (IOException ex) {
                }
                if (tmp != null) {
                    response.append(tmp);
                }
            } while (tmp != null);
            returnEntry = response.toString();
        }

        public void setJSONresults() {
            try {
                JSONObject obj1 = new JSONObject(returnEntry);
                mBearerToken = obj1.getString("access_token");
                mTokenType = obj1.getString("token_type");
            } catch (JSONException ex) {
            }
        }

        @Override
        protected void onPostExecute(Void result) {
            finished = true;
            saveAuthenticationInformation();
            notifyListener();
        }

        @Override
        protected Void doInBackground(String... params) {
            finished = false;
            if (mBearerToken == null) {
                sendPostRequestToGetBearerToken();
            }
            return null;
        }
    }
}