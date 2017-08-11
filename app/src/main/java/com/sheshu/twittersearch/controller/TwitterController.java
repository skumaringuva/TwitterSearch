package com.sheshu.twittersearch.controller;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;

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
import java.util.List;

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

    public void searchTwitter(List<String> params) {
        StringBuilder searchKey = new StringBuilder();
        for (String key : params) {
            if (searchKey.length() != 0) {
                searchKey.append(" ");
            }
            searchKey.append(key);
        }
        String searchKeyUrlEncoded = null;
        try {
            searchKeyUrlEncoded = URLEncoder.encode(searchKey.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(searchKeyUrlEncoded)) {
            searchKeyUrlEncoded = "elephant";
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
        Call<Tweets> call = api.getSearchResults(token, searchKeyUrlEncoded);
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
            StringBuffer response = new StringBuffer();
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