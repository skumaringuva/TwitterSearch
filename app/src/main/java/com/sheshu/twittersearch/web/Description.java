package com.sheshu.twittersearch.web;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Description implements Parcelable {
    public final static Creator<Description> CREATOR = new Creator<Description>() {
        @SuppressWarnings({
                "unchecked"
        })
        public Description createFromParcel(Parcel in) {
            Description instance = new Description();
            in.readList(instance.urls, (Object.class.getClassLoader()));
            return instance;
        }

        public Description[] newArray(int size) {
            return (new Description[size]);
        }
    };
    @SerializedName("urls")
    @Expose
    private List<Object> urls = null;

    public List<Object> getUrls() {
        return urls;
    }

    public void setUrls(List<Object> urls) {
        this.urls = urls;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(urls);
    }

    public int describeContents() {
        return 0;
    }
}
