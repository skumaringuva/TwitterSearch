package com.sheshu.twittersearch.Utils;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.sheshu.twittersearch.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

/**
 * Utils class for common functions.
 */
public class Utils {
    /**
     * @param context   Context of the call
     * @param imageView View where to load the downloaded image.
     * @param id        place holder Id of resource if we cannot download the image.
     * @param imageUrl  Image Url to download.
     */
    public static void makeImageRequest(final Context context, final ImageView imageView, final int id, final String imageUrl) {
        Picasso.with(context)
                .load(imageUrl)
                //   .networkPolicy(NetworkPolicy.OFFLINE)
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.v("Picasso", "fetch image success in first time.");
                    }

                    @Override
                    public void onError() {
                        //Try again online if cache failed
                        Log.v("Picasso", "Could not fetch image in first time...");
                        Picasso.with(context).load(imageUrl).networkPolicy(NetworkPolicy.NO_CACHE)
                                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).error(id)
                                .into(imageView, new Callback() {
                                    @Override
                                    public void onSuccess() {
                                        Log.v("Picasso", "fetch image success in try again.");
                                    }

                                    @Override
                                    public void onError() {
                                        Log.v("Picasso", "Could not fetch image again...");
                                    }
                                });
                    }
                });
    }
    // Patch this code if we need to put twitter authentication inside the download request.
   /*        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                           .authenticator(new Authenticator()
                           {
                               @Override
                               public Request authenticate(Route route, Response response) throws IOException
                               {
                                   String credential =  Credentials.basic("username","password");
                                   return response.request().newBuilder()
                                           .header("Authorization", credential)
                                           .build();
                               }
                           }).build();

                   Picasso picasso = new Picasso.Builder(OnDemandImageCaptureActivity.this)
                           .downloader(new OkHttp3Downloader(okHttpClient))
                           .build();
                        picasso.load("http://example.com/abc.jpeg").into(ivcamera);*/

    /**
     * @param textView Target view to load the text.
     * @param prefix   Text prefix.
     * @param text     Text to display.
     */
    public static void setTextWithPrefix(TextView textView, String prefix, String text) {
        String string = text == null ? prefix : (prefix + " " + text);
        textView.setText(string);
    }

    public static SearchView configureSearchView(Menu menu, MenuInflater inflater, Activity activity,
                                                 int searchResourceId, SearchView.OnQueryTextListener listener) {
        inflater.inflate(searchResourceId, menu);
        SearchView searchView = null;
        if (activity != null) {
            SearchManager manager = (SearchManager) activity.getSystemService(Context.SEARCH_SERVICE);
            MenuItem searchMenuItem = (MenuItem) menu.findItem(R.id.action_search);
            searchView = (SearchView) searchMenuItem.getActionView();
            searchView.setIconified(false);
            searchView.setSearchableInfo(manager.getSearchableInfo(activity.getComponentName()));
            searchView.setSubmitButtonEnabled(false);
            searchView.setOnQueryTextListener(listener);
            searchMenuItem.expandActionView();
            searchView.clearFocus(); // close the keyboard on load
            MenuItemCompat.setOnActionExpandListener(searchMenuItem, new MenuItemCompat.OnActionExpandListener() {
                @Override
                public boolean onMenuItemActionExpand(MenuItem item) {
                    return true;
                }

                @Override
                public boolean onMenuItemActionCollapse(MenuItem item) {
                    // Write your code here
                    return true;
                }
            });
        }
        return searchView;
    }

    public static void loadFragment(AppCompatActivity activity, int containerResourceId, Class myFragmentClass, String tag) {
        try {
            Fragment myFragment = (Fragment) myFragmentClass.newInstance();
            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(containerResourceId, myFragment, tag);
            fragmentTransaction.commit();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

