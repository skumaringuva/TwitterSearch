package com.sheshu.twittersearch.web;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchMetadata implements Parcelable {
    public final static Creator<SearchMetadata> CREATOR = new Creator<SearchMetadata>() {
        @SuppressWarnings({
                "unchecked"
        })
        public SearchMetadata createFromParcel(Parcel in) {
            SearchMetadata instance = new SearchMetadata();
            instance.maxId = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.sinceId = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.refreshUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.nextResults = ((String) in.readValue((String.class.getClassLoader())));
            instance.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.completedIn = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.sinceIdStr = ((String) in.readValue((String.class.getClassLoader())));
            instance.query = ((String) in.readValue((String.class.getClassLoader())));
            instance.maxIdStr = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public SearchMetadata[] newArray(int size) {
            return (new SearchMetadata[size]);
        }
    };
    @SerializedName("max_id")
    @Expose
    private Long maxId;
    @SerializedName("since_id")
    @Expose
    private Integer sinceId;
    @SerializedName("refresh_url")
    @Expose
    private String refreshUrl;
    @SerializedName("next_results")
    @Expose
    private String nextResults;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("completed_in")
    @Expose
    private Double completedIn;
    @SerializedName("since_id_str")
    @Expose
    private String sinceIdStr;
    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("max_id_str")
    @Expose
    private String maxIdStr;

    public Long getMaxId() {
        return maxId;
    }

    public void setMaxId(Long maxId) {
        this.maxId = maxId;
    }

    public Integer getSinceId() {
        return sinceId;
    }

    public void setSinceId(Integer sinceId) {
        this.sinceId = sinceId;
    }

    public String getRefreshUrl() {
        return refreshUrl;
    }

    public void setRefreshUrl(String refreshUrl) {
        this.refreshUrl = refreshUrl;
    }

    public String getNextResults() {
        return nextResults;
    }

    public void setNextResults(String nextResults) {
        this.nextResults = nextResults;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getCompletedIn() {
        return completedIn;
    }

    public void setCompletedIn(Double completedIn) {
        this.completedIn = completedIn;
    }

    public String getSinceIdStr() {
        return sinceIdStr;
    }

    public void setSinceIdStr(String sinceIdStr) {
        this.sinceIdStr = sinceIdStr;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getMaxIdStr() {
        return maxIdStr;
    }

    public void setMaxIdStr(String maxIdStr) {
        this.maxIdStr = maxIdStr;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(maxId);
        dest.writeValue(sinceId);
        dest.writeValue(refreshUrl);
        dest.writeValue(nextResults);
        dest.writeValue(count);
        dest.writeValue(completedIn);
        dest.writeValue(sinceIdStr);
        dest.writeValue(query);
        dest.writeValue(maxIdStr);
    }

    public int describeContents() {
        return 0;
    }
}
