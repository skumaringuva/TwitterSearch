package com.sheshu.twittersearch.web;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status implements Parcelable {
    public final static Creator<Status> CREATOR = new Creator<Status>() {
        @SuppressWarnings({
                "unchecked"
        })
        public Status createFromParcel(Parcel in) {
            Status instance = new Status();
            instance.coordinates = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.favorited = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.truncated = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.createdAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.idStr = ((String) in.readValue((String.class.getClassLoader())));
            instance.entities = ((Entities) in.readValue((Entities.class.getClassLoader())));
            instance.inReplyToUserIdStr = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.contributors = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.text = ((String) in.readValue((String.class.getClassLoader())));
            instance.metadata = ((Metadata) in.readValue((Metadata.class.getClassLoader())));
            instance.retweetCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.inReplyToStatusIdStr = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.geo = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.retweeted = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.inReplyToUserId = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.place = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.user = ((User) in.readValue((User.class.getClassLoader())));
            instance.inReplyToScreenName = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.source = ((String) in.readValue((String.class.getClassLoader())));
            instance.inReplyToStatusId = ((Object) in.readValue((Object.class.getClassLoader())));
            return instance;
        }

        public Status[] newArray(int size) {
            return (new Status[size]);
        }
    };
    @SerializedName("coordinates")
    @Expose
    private Object coordinates;
    @SerializedName("favorited")
    @Expose
    private Boolean favorited;
    @SerializedName("truncated")
    @Expose
    private Boolean truncated;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("id_str")
    @Expose
    private String idStr;
    @SerializedName("entities")
    @Expose
    private Entities entities;
    @SerializedName("in_reply_to_user_id_str")
    @Expose
    private Object inReplyToUserIdStr;
    @SerializedName("contributors")
    @Expose
    private Object contributors;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("retweet_count")
    @Expose
    private Integer retweetCount;
    @SerializedName("in_reply_to_status_id_str")
    @Expose
    private Object inReplyToStatusIdStr;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("geo")
    @Expose
    private Object geo;
    @SerializedName("retweeted")
    @Expose
    private Boolean retweeted;
    @SerializedName("in_reply_to_user_id")
    @Expose
    private Object inReplyToUserId;
    @SerializedName("place")
    @Expose
    private Object place;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("in_reply_to_screen_name")
    @Expose
    private Object inReplyToScreenName;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("in_reply_to_status_id")
    @Expose
    private Object inReplyToStatusId;

    public Object getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Object coordinates) {
        this.coordinates = coordinates;
    }

    public Boolean getFavorited() {
        return favorited;
    }

    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }

    public Boolean getTruncated() {
        return truncated;
    }

    public void setTruncated(Boolean truncated) {
        this.truncated = truncated;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public Entities getEntities() {
        return entities;
    }

    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    public Object getInReplyToUserIdStr() {
        return inReplyToUserIdStr;
    }

    public void setInReplyToUserIdStr(Object inReplyToUserIdStr) {
        this.inReplyToUserIdStr = inReplyToUserIdStr;
    }

    public Object getContributors() {
        return contributors;
    }

    public void setContributors(Object contributors) {
        this.contributors = contributors;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Integer getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(Integer retweetCount) {
        this.retweetCount = retweetCount;
    }

    public Object getInReplyToStatusIdStr() {
        return inReplyToStatusIdStr;
    }

    public void setInReplyToStatusIdStr(Object inReplyToStatusIdStr) {
        this.inReplyToStatusIdStr = inReplyToStatusIdStr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getGeo() {
        return geo;
    }

    public void setGeo(Object geo) {
        this.geo = geo;
    }

    public Boolean getRetweeted() {
        return retweeted;
    }

    public void setRetweeted(Boolean retweeted) {
        this.retweeted = retweeted;
    }

    public Object getInReplyToUserId() {
        return inReplyToUserId;
    }

    public void setInReplyToUserId(Object inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
    }

    public Object getPlace() {
        return place;
    }

    public void setPlace(Object place) {
        this.place = place;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Object getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public void setInReplyToScreenName(Object inReplyToScreenName) {
        this.inReplyToScreenName = inReplyToScreenName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Object getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    public void setInReplyToStatusId(Object inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(coordinates);
        dest.writeValue(favorited);
        dest.writeValue(truncated);
        dest.writeValue(createdAt);
        dest.writeValue(idStr);
        dest.writeValue(entities);
        dest.writeValue(inReplyToUserIdStr);
        dest.writeValue(contributors);
        dest.writeValue(text);
        dest.writeValue(metadata);
        dest.writeValue(retweetCount);
        dest.writeValue(inReplyToStatusIdStr);
        dest.writeValue(id);
        dest.writeValue(geo);
        dest.writeValue(retweeted);
        dest.writeValue(inReplyToUserId);
        dest.writeValue(place);
        dest.writeValue(user);
        dest.writeValue(inReplyToScreenName);
        dest.writeValue(source);
        dest.writeValue(inReplyToStatusId);
    }

    public int describeContents() {
        return 0;
    }
}
