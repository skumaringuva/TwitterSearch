package com.sheshu.twittersearch.web;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tweets implements Parcelable {
    public final static Creator<Tweets> CREATOR = new Creator<Tweets>() {
        @SuppressWarnings({
                "unchecked"
        })
        public Tweets createFromParcel(Parcel in) {
            Tweets instance = new Tweets();
            in.readList(instance.statuses, (Status.class.getClassLoader()));
            instance.searchMetadata = ((SearchMetadata) in.readValue((SearchMetadata.class.getClassLoader())));
            return instance;
        }

        public Tweets[] newArray(int size) {
            return (new Tweets[size]);
        }
    };
    @SerializedName("statuses")
    @Expose
    private List<Status> statuses = null;
    @SerializedName("search_metadata")
    @Expose
    private SearchMetadata searchMetadata;

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }

    public SearchMetadata getSearchMetadata() {
        return searchMetadata;
    }

    public void setSearchMetadata(SearchMetadata searchMetadata) {
        this.searchMetadata = searchMetadata;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(statuses);
        dest.writeValue(searchMetadata);
    }

    public int describeContents() {
        return 0;
    }
}
