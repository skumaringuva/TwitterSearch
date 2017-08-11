package com.sheshu.twittersearch.web;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Url implements Parcelable {
    public final static Creator<Url> CREATOR = new Creator<Url>() {
        @SuppressWarnings({
                "unchecked"
        })
        public Url createFromParcel(Parcel in) {
            Url instance = new Url();
            in.readList(instance.urls, (com.sheshu.twittersearch.web.Url_.class.getClassLoader()));
            return instance;
        }

        public Url[] newArray(int size) {
            return (new Url[size]);
        }
    };
    @SerializedName("urls")
    @Expose
    private List<Url_> urls = null;

    public List<Url_> getUrls() {
        return urls;
    }

    public void setUrls(List<Url_> urls) {
        this.urls = urls;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(urls);
    }

    public int describeContents() {
        return 0;
    }
}
