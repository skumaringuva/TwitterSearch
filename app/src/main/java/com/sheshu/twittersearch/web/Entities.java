package com.sheshu.twittersearch.web;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Entities implements Parcelable {
    public final static Creator<Entities> CREATOR = new Creator<Entities>() {
        @SuppressWarnings({
                "unchecked"
        })
        public Entities createFromParcel(Parcel in) {
            Entities instance = new Entities();
            in.readList(instance.urls, (Object.class.getClassLoader()));
            in.readList(instance.hashtags, (Hashtag.class.getClassLoader()));
            in.readList(instance.userMentions, (Object.class.getClassLoader()));
            return instance;
        }

        public Entities[] newArray(int size) {
            return (new Entities[size]);
        }
    };
    @SerializedName("urls")
    @Expose
    private List<Object> urls = null;
    @SerializedName("hashtags")
    @Expose
    private List<Hashtag> hashtags = null;
    @SerializedName("user_mentions")
    @Expose
    private List<Object> userMentions = null;

    public List<Object> getUrls() {
        return urls;
    }

    public void setUrls(List<Object> urls) {
        this.urls = urls;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public List<Object> getUserMentions() {
        return userMentions;
    }

    public void setUserMentions(List<Object> userMentions) {
        this.userMentions = userMentions;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(urls);
        dest.writeList(hashtags);
        dest.writeList(userMentions);
    }

    public int describeContents() {
        return 0;
    }
}
