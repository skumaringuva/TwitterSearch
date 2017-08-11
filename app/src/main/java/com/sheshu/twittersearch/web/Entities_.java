package com.sheshu.twittersearch.web;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entities_ implements Parcelable {
    public final static Creator<Entities_> CREATOR = new Creator<Entities_>() {
        @SuppressWarnings({
                "unchecked"
        })
        public Entities_ createFromParcel(Parcel in) {
            Entities_ instance = new Entities_();
            instance.url = ((Url) in.readValue((Url.class.getClassLoader())));
            instance.description = ((Description) in.readValue((Description.class.getClassLoader())));
            return instance;
        }

        public Entities_[] newArray(int size) {
            return (new Entities_[size]);
        }
    };
    @SerializedName("url")
    @Expose
    private Url url;
    @SerializedName("description")
    @Expose
    private Description description;

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(description);
    }

    public int describeContents() {
        return 0;
    }
}
