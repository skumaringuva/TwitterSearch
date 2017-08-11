package com.sheshu.twittersearch.web;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hashtag implements Parcelable {
    public final static Creator<Hashtag> CREATOR = new Creator<Hashtag>() {
        @SuppressWarnings({
                "unchecked"
        })
        public Hashtag createFromParcel(Parcel in) {
            Hashtag instance = new Hashtag();
            instance.text = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.indices, (Integer.class.getClassLoader()));
            return instance;
        }

        public Hashtag[] newArray(int size) {
            return (new Hashtag[size]);
        }
    };
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("indices")
    @Expose
    private List<Integer> indices = null;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Integer> getIndices() {
        return indices;
    }

    public void setIndices(List<Integer> indices) {
        this.indices = indices;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(text);
        dest.writeList(indices);
    }

    public int describeContents() {
        return 0;
    }
}
