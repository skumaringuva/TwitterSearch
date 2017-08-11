package com.sheshu.twittersearch.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sheshu.twittersearch.R;
import com.sheshu.twittersearch.Utils.Utils;

public class TwitterSearchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_search);
        Utils.loadFragment(this, R.id.tweets_fragment_holder, TwitterSearchFragment.class, "twitter_search_fragment");
    }

    @Override
    public void onBackPressed() {
        int fragments = getFragmentManager().getBackStackEntryCount();
        if (fragments == 1) {
        }
        super.onBackPressed();
    }
}
