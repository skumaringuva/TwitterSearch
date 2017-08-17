package com.sheshu.twittersearch.view;

import android.app.DatePickerDialog;
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
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.sheshu.twittersearch.R;
import com.sheshu.twittersearch.Utils.Utils;
import com.sheshu.twittersearch.controller.TwitterController;
import com.sheshu.twittersearch.controller.TwitterNotifier;
import com.sheshu.twittersearch.web.StatusesItem;

import java.util.GregorianCalendar;
import java.util.List;

import butterknife.BindView;
import butterknife.OnCheckedChanged;

/**
 * A placeholder fragment containing a simple view.
 */
public class TwitterSearchFragment extends Fragment
        implements DatePickerDialog.OnDateSetListener {
    private static final String SAVED_TWEETS_KEY = "saved_tweets_key";
    private static final String SAVED_SEARCH_HISTORY = "saved_search_history";
    TwitterController mTwitterController;
    RecyclerView mTweetRecyclerView;
    TweetStreamRecyclerAdapter mTweetAdapter;
    SparseArray<String> mKeywords;
    DatePickerDialog mDatePickerDialog;
    int mDateRequestId = 0;
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
        private void updateUIList(List<StatusesItem> statuses) {
            mTweetAdapter.setItemList(statuses);
            mTweetRecyclerView.invalidate();
            mTweetRecyclerView.getRecycledViewPool().clear();
        }

        @Override
        public void searchResults(List<StatusesItem> statuses) {
            updateUIList(statuses);
        }

        @Override
        public void searchError() {
        }
    };
    @BindView(R.id.checkbox_since_date)
    CheckBox mSinceDate;
    @BindView(R.id.checkbox_until_date)
    CheckBox mUntilDate;
    private Menu mMenu;
    private SearchView mSearchView;
    private View mView;
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mKeywords = new SparseArray<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_twitter_search, container, false);
        Toolbar toolbar = (Toolbar) mView.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        mTweetRecyclerView = (RecyclerView) mView.findViewById(R.id.tweet_recycler_view);
        mTweetRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mTweetAdapter = new TweetStreamRecyclerAdapter(getActivity(), null, mTweetClickListener);
        mTweetRecyclerView.setAdapter(mTweetAdapter);
        FloatingActionButton fab = (FloatingActionButton) mView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Searching again", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                mTwitterController.searchTwitter(mKeywords);
            }
        });
       /* if (savedInstanceState != null && savedInstanceState.containsKey(SAVED_TWEETS_KEY)) {
            ArrayList<StatusesItem> tweets = savedInstanceState.getParcelableArrayList(SAVED_TWEETS_KEY);
            mTweetAdapter.setItemList(StatusesItem);
        }*/
        GregorianCalendar calendar = new GregorianCalendar();
        mDatePickerDialog = new DatePickerDialog(
                getActivity(), this, calendar.get(GregorianCalendar.YEAR), calendar.get(GregorianCalendar.MONTH), calendar.get(GregorianCalendar.DAY_OF_MONTH));
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTwitterController = new TwitterController(getActivity());
        mTwitterController.login(mTwitterNotifer);
    }

    private void searchWithKeyword(String keyword) {
        createSearchKeywords(keyword);
        mTwitterController.searchTwitter(mKeywords);
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

    ;

    private void createSearchKeywords(String keyword) {
        int[] checkboxIdArray = new int[]{
                R.id.checkbox_exact,
                R.id.checkbox_safe,
                R.id.checkbox_media,
                R.id.checkbox_native_video,
                R.id.checkbox_not_from_retweets,
                R.id.checkbox_periscope,
                R.id.checkbox_vine,
                R.id.checkbox_images,
                R.id.checkbox_twimg,
                R.id.checkbox_no_scary,
                R.id.checkbox_positive,
                R.id.checkbox_negative,
                R.id.checkbox_since_date,
                R.id.checkbox_until_date,
        };
        int[] editTextArray = new int[]{
                R.id.edit_text_doesnt_contain,
                R.id.edit_text_from_account,
                R.id.edit_text_from_list,
                R.id.edit_text_to_account
        };
        // clear all the previous settings for the search.
        mKeywords.clear();
        for (int resourceId : checkboxIdArray) {
            CheckBox checkbox = (CheckBox) mView.findViewById(resourceId);
            if (checkbox != null && checkbox.isChecked()) {
                addKeywordFromResource(resourceId, keyword);
            }
        }
        // If no option selected by user, then add normal keyword to the list
        if (mKeywords.get(TwitterController.SEARCH_TYPE_EXACT) == null) {
            mKeywords.put(TwitterController.SEARCH_TYPE_NORMAL, keyword);
        }
        for (int resourceId : editTextArray) {
            EditText editText = (EditText) mView.findViewById(resourceId);
            if (editText != null) {
                String splKeyword = editText.getText().toString();
                if (!TextUtils.isEmpty(splKeyword)) {
                    addKeywordFromResource(resourceId, splKeyword);
                }
            }
        }
    }

    void addKeywordFromResource(int resourceId, String keyword) {
        switch (resourceId) {
            case R.id.checkbox_exact:
                mKeywords.put(TwitterController.SEARCH_TYPE_EXACT,
                        TwitterController.addKeyword(TwitterController.SEARCH_TYPE_EXACT, keyword));
                break;
            case R.id.checkbox_safe:
                mKeywords.put(TwitterController.SEARCH_TYPE_FILTER_SAFE,
                        TwitterController.addKeyword(TwitterController.SEARCH_TYPE_FILTER_SAFE, ""));
                break;
            case R.id.checkbox_media:
                mKeywords.put(TwitterController.SEARCH_TYPE_FILTER_MEDIA,
                        TwitterController.addKeyword(TwitterController.SEARCH_TYPE_FILTER_MEDIA, ""));
                break;
            case R.id.checkbox_native_video:
                mKeywords.put(TwitterController.SEARCH_TYPE_FILTER_NATIVE_VIDEO,
                        TwitterController.addKeyword(TwitterController.SEARCH_TYPE_FILTER_NATIVE_VIDEO, ""));
                break;
            case R.id.checkbox_not_from_retweets:
                mKeywords.put(TwitterController.SEARCH_TYPE_FILTER_NO_RETWEETS,
                        TwitterController.addKeyword(TwitterController.SEARCH_TYPE_FILTER_NO_RETWEETS, ""));
                break;
            case R.id.checkbox_periscope:
                mKeywords.put(TwitterController.SEARCH_TYPE_FILTER_PERISCOPE,
                        TwitterController.addKeyword(TwitterController.SEARCH_TYPE_FILTER_PERISCOPE, ""));
                break;
            case R.id.checkbox_vine:
                mKeywords.put(TwitterController.SEARCH_TYPE_FILTER_VINE,
                        TwitterController.addKeyword(TwitterController.SEARCH_TYPE_FILTER_VINE, ""));
                break;
            case R.id.checkbox_images:
                mKeywords.put(TwitterController.SEARCH_TYPE_FILTER_IMAGES,
                        TwitterController.addKeyword(TwitterController.SEARCH_TYPE_FILTER_IMAGES, ""));
                break;
            case R.id.checkbox_twimg:
                mKeywords.put(TwitterController.SEARCH_TYPE_FILTER_TWIMG,
                        TwitterController.addKeyword(TwitterController.SEARCH_TYPE_FILTER_TWIMG, ""));
                break;
            case R.id.checkbox_no_scary:
                mKeywords.put(TwitterController.SEARCH_TYPE_FILTER_NO_SCARY,
                        TwitterController.addKeyword(TwitterController.SEARCH_TYPE_FILTER_NO_SCARY, ""));
                break;
            case R.id.checkbox_positive:
                mKeywords.put(TwitterController.SEARCH_TYPE_FILTER_POSITIVE_ATTITUDE,
                        TwitterController.addKeyword(TwitterController.SEARCH_TYPE_FILTER_POSITIVE_ATTITUDE, ""));
                break;
            case R.id.checkbox_negative:
                mKeywords.put(TwitterController.SEARCH_TYPE_FILTER_NEGATIVE_ATTITUDE,
                        TwitterController.addKeyword(TwitterController.SEARCH_TYPE_FILTER_NEGATIVE_ATTITUDE, ""));
                break;
            case R.id.checkbox_since_date:
                mKeywords.put(TwitterController.SEARCH_TYPE_FILTER_SINCE,
                        TwitterController.addKeyword(TwitterController.SEARCH_TYPE_FILTER_SINCE, mSinceDate.getText().toString()));
                break;
            case R.id.checkbox_until_date:
                mKeywords.put(TwitterController.SEARCH_TYPE_FILTER_UNTIL,
                        TwitterController.addKeyword(TwitterController.SEARCH_TYPE_FILTER_UNTIL, mUntilDate.getText().toString()));
                break;
            case R.id.edit_text_doesnt_contain:
                mKeywords.put(TwitterController.SEARCH_TYPE_NOT_KEYWORD,
                        TwitterController.addKeyword(TwitterController.SEARCH_TYPE_NOT_KEYWORD, keyword));
                break;
            case R.id.edit_text_to_account:
                mKeywords.put(TwitterController.SEARCH_TYPE_TO_ACCOUNT,
                        TwitterController.addKeyword(TwitterController.SEARCH_TYPE_TO_ACCOUNT, keyword));
                break;
            case R.id.edit_text_from_list:
                mKeywords.put(TwitterController.SEARCH_TYPE_FROM_LIST,
                        TwitterController.addKeyword(TwitterController.SEARCH_TYPE_FROM_LIST, keyword));
                break;
            case R.id.edit_text_from_account:
                mKeywords.put(TwitterController.SEARCH_TYPE_FROM_ACCOUNT,
                        TwitterController.addKeyword(TwitterController.SEARCH_TYPE_FROM_ACCOUNT, keyword));
                break;
            default:
                mKeywords.put(TwitterController.SEARCH_TYPE_NORMAL, keyword);
                break;
        }
    }

    @OnCheckedChanged({R.id.checkbox_since_date, R.id.checkbox_until_date})
    void onDateCheckboxSelected(CompoundButton button, boolean checked) {
        if (checked) {
            mDateRequestId = button.getId();
            mDatePickerDialog.show();
        } else {
            if (button.getId() == R.id.checkbox_since_date) {
                mSinceDate.setText(null);
            } else if (button.getId() == R.id.checkbox_until_date) {
                mUntilDate.setText(null);
            }
            ;
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        // TODO: Check for 0 index or 1 index.
        String date = "" + year + "-" + month + "-" + dayOfMonth;
        if (mDateRequestId == R.id.checkbox_since_date) {
            mSinceDate.setText(date);
        } else if (mDateRequestId == R.id.checkbox_until_date) {
            mUntilDate.setText(date);
        }
        ;
    }




/*
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(SAVED_TWEETS_KEY, mTweetAdapter.getItemList());
    }*/
}
