package com.sheshu.twittersearch.web;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Url_ implements Parcelable {
    public final static Creator<Url_> CREATOR = new Creator<Url_>() {
        @SuppressWarnings({
                "unchecked"
        })
        public Url_ createFromParcel(Parcel in) {
            Url_ instance = new Url_();
            instance.expandedUrl = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.indices, (Integer.class.getClassLoader()));
            return instance;
        }

        public Url_[] newArray(int size) {
            return (new Url_[size]);
        }
    };
    @SerializedName("expanded_url")
    @Expose
    private Object expandedUrl;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("indices")
    @Expose
    private List<Integer> indices = null;

    public Object getExpandedUrl() {
        return expandedUrl;
    }

    public void setExpandedUrl(Object expandedUrl) {
        this.expandedUrl = expandedUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Integer> getIndices() {
        return indices;
    }

    public void setIndices(List<Integer> indices) {
        this.indices = indices;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(expandedUrl);
        dest.writeValue(url);
        dest.writeList(indices);
    }

    public int describeContents() {
        return 0;
    }
}
