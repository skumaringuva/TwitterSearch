package com.sheshu.twittersearch.view;

import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sheshu.twittersearch.R;
import com.sheshu.twittersearch.Utils.Utils;
import com.sheshu.twittersearch.web.Entities;
import com.sheshu.twittersearch.web.MediaItem;
import com.sheshu.twittersearch.web.StatusesItem;

import java.util.ArrayList;
import java.util.List;

/**
 * This is recycler view adapter which will load the Tweet on a card view item.
 */
class TweetStreamRecyclerAdapter extends RecyclerView.Adapter {
    private static final String TAG = "adapter";
    private static final int CARD_TYPE_SIMPLE = 0;
    //private static final String TAG = "RecAdapter";
    private final Context mContext;
    private final View.OnClickListener mOnClickListener;
    final private SparseArrayCompat<String> mStringMap;
    private List<StatusesItem> mItemList;

    TweetStreamRecyclerAdapter(Context context, List<StatusesItem> reviewsList, View.OnClickListener onClickListener) {
        mItemList = reviewsList;
        mStringMap = new SparseArrayCompat<>();
        mContext = context;
        mOnClickListener = onClickListener;
    }

    ArrayList<StatusesItem> getItemList() {
        return (ArrayList<StatusesItem>) mItemList;
    }

    void setItemList(List<StatusesItem> reviewsList) {
        mItemList = reviewsList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        CardView v = null;
        //if(viewType == CARD_TYPE_SIMPLE)
        {
            v = (CardView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.tweet_type_simple, parent, false);
        }
        v.setOnClickListener(mOnClickListener);
        return new MyViewHolder(v, 0);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //if (getItemViewType(position) == CARD_TYPE_SIMPLE)
        {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            StatusesItem status = mItemList.get(position);
            String userPhotoUrl = status.getUser().getProfileImageUrl();
            if (!TextUtils.isEmpty(userPhotoUrl)) {
                Utils.makeImageRequest(mContext, myViewHolder.mUserPhoto, R.mipmap.ic_tweeter_place_holder, userPhotoUrl);
            }
            myViewHolder.mMediaLayout.removeAllViews();
            Entities entities = status.getEntities();
            if (entities != null && entities.getMedia() != null) {
                for (MediaItem item : entities.getMedia()) {
                    // LinkedTreeMap<String, String> urlMap = (LinkedTreeMap<String, String>) url;
                    if (item != null) {
                        String mediaUrl = item.getMediaUrl();
                        Log.e(TAG, "url: " + item.getUrl());
                        Log.e(TAG, "expanded: " + item.getExpandedUrl());
                        Log.e(TAG, "display: " + item.getDisplayUrl());
                        if (!TextUtils.isEmpty(mediaUrl)) {
                            ImageView imageView = new ImageView(mContext);
                            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                            myViewHolder.mMediaLayout.addView(imageView,
                                    new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                            Utils.makeImageRequest(mContext, imageView, R.mipmap.ic_tweeter_place_holder, mediaUrl);
                        }
                        Log.e(TAG, "Media url: " + item.getMediaUrl());
                    }
                }
            }
            myViewHolder.status.setText(status.getText());
            String rw = "" + status.getRetweetCount();
            myViewHolder.reTweetCount.setText(rw);
            String favCount = "" + status.getUser().getFavouritesCount();
            myViewHolder.favCount.setText(favCount);
            String userHandle = "@" + status.getUser().getScreenName();
            Log.d(TAG, "getProfileBackgroundColor: " + status.getUser().getProfileBackgroundColor() +
                    "backgroundImageUrl: " + status.getUser().getProfileBackgroundImageUrl()
                    + "getProfileLinkColor: " + status.getUser().getProfileLinkColor()
                    + "getProfileSidebarBorderColor " + status.getUser().getProfileSidebarBorderColor()
                    + "getProfileSidebarFillColor " + status.getUser().getProfileSidebarFillColor()
                    + "getProfileTextColor " + status.getUser().getProfileTextColor());
            status.getCreatedAt();
            myViewHolder.userName.setText(status.getUser().getName());
            myViewHolder.userHandle.setText(userHandle);
            // myViewHolder.favCount.setText(status.getMetadata().);
        }
    }

    @Override
    public int getItemCount() {
        return (mItemList != null ? mItemList.size() : 0);
    }

    // Not using, drawing all tweets in uniform cards.
    @Override
    public int getItemViewType(int position) {
        return CARD_TYPE_SIMPLE;
    }

    private String getStringResource(int resource) {
        String value = mStringMap.get(resource, null);
        if (value != null)
            return value;
        else {
            String cachedString = mContext.getString(resource);
            mStringMap.put(resource, cachedString);
            return cachedString;
        }
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView userHandle;
        TextView userName;
        TextView status;
        TextView reTweetCount;
        TextView favCount;
        TextView replyCount;
        ImageView mUserPhoto;
        LinearLayout mMediaLayout;
        WebView previewWebsite;

        MyViewHolder(CardView v, int type) {
            super(v);
            if (type == CARD_TYPE_SIMPLE) {
                userHandle = (TextView) v.findViewById(R.id.user_twitter_handle);
                userName = (TextView) v.findViewById(R.id.user_twitter_name);
                mUserPhoto = (ImageView) v.findViewById(R.id.user_photo);
                mMediaLayout = (LinearLayout) v.findViewById(R.id.media_layout);
                status = (TextView) v.findViewById(R.id.status);
                reTweetCount = (TextView) v.findViewById(R.id.retweet_count);
                favCount = (TextView) v.findViewById(R.id.fav_count);
                replyCount = (TextView) v.findViewById(R.id.reply_count);
                previewWebsite = (WebView) v.findViewById(R.id.preview_website);
            }
        }
    }
}








