package com.sheshu.twittersearch.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.sheshu.twittersearch.R;
import com.sheshu.twittersearch.Utils.Utils;
import com.sheshu.twittersearch.controller.TwitterController;
import com.sheshu.twittersearch.controller.TwitterNotifier;
import com.sheshu.twittersearch.web.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class TwitterSearchFragment extends Fragment {
    private static final String SAVED_TWEETS_KEY = "saved_tweets_key";
    private static final String SAVED_SEARCH_HISTORY = "saved_search_history";
    TwitterController mTwitterController;
    RecyclerView mTweetRecyclerView;
    TweetStreamRecyclerAdapter mTweetAdapter;
    View.OnClickListener mTweetClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Do nothing.
        }
    };
    TwitterNotifier mTwitterNotifer = new TwitterNotifier() {
        @Override
        public void onAuthenticated(boolean isSuccess) {
            if (isSuccess) {
                if (getView() != null) {
                    //  Snackbar.make(getView(), "Twitter Login successful", Snackbar.LENGTH_LONG)
                    //          .setAction("Action", null).show();
                    Toast.makeText(getActivity(), "Twitter Login successful", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getActivity(), "Twitter Login successful", Toast.LENGTH_SHORT).show();
            } else {
                if (getView() != null) {
                    //  Snackbar.make(getView(), "Twitter login failed", Snackbar.LENGTH_LONG)
                    //       .setAction("Action", null).show();
                    Toast.makeText(getActivity(), "Twitter Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        }

        @UiThread
        private void updateUIList(List<Status> statuses) {
            mTweetAdapter.setItemList(statuses);
            mTweetRecyclerView.invalidate();
            mTweetRecyclerView.getRecycledViewPool().clear();
        }

        @Override
        public void searchResults(List<Status> statuses) {
            updateUIList(statuses);
        }

        @Override
        public void searchError() {
        }
    };
    private Menu mMenu;
    private SearchView mSearchView;
    SearchView.OnQueryTextListener mSearchTextListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            searchWithKeyword(query);
            mSearchView.clearFocus();
            return true;
        }

        @Override
        public boolean onQueryTextChange(String query) {
            return false;
        }
    };

    public TwitterSearchFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_twitter_search, container, false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        mTweetRecyclerView = (RecyclerView) view.findViewById(R.id.tweet_recycler_view);
        mTweetRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mTweetAdapter = new TweetStreamRecyclerAdapter(getActivity(), null, mTweetClickListener);
        mTweetRecyclerView.setAdapter(mTweetAdapter);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Searching again", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                ArrayList<String> keywords = new ArrayList<>();
                keywords.add("elephant");
                mTwitterController.searchTwitter(keywords);
            }
        });
        if (savedInstanceState != null && savedInstanceState.containsKey(SAVED_TWEETS_KEY)) {
            ArrayList<Status> tweets = savedInstanceState.getParcelableArrayList(SAVED_TWEETS_KEY);
            mTweetAdapter.setItemList(tweets);
        }
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTwitterController = new TwitterController(getActivity());
        mTwitterController.login(mTwitterNotifer);
    }

    private void searchWithKeyword(String keyword) {
        ArrayList<String> keywords = new ArrayList<>();
        keywords.add(keyword);
        mTwitterController.searchTwitter(keywords);
    }

    private void showError() {
        if (getView() != null) {
            Snackbar snackbar = Snackbar
                    .make(getView(), "Error loading \n Please refresh from menu!!", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        mSearchView = Utils.configureSearchView(menu, inflater, getActivity(), R.menu.menu_twitter_search, mSearchTextListener);
        mSearchView.setQueryHint(getString(R.string.search_hint));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(SAVED_TWEETS_KEY, mTweetAdapter.getItemList());
    }
}
