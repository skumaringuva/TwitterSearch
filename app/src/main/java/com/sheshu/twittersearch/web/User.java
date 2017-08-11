package com.sheshu.twittersearch.web;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {
    public final static Creator<User> CREATOR = new Creator<User>() {
        @SuppressWarnings({
                "unchecked"
        })
        public User createFromParcel(Parcel in) {
            User instance = new User();
            instance.profileSidebarFillColor = ((String) in.readValue((String.class.getClassLoader())));
            instance.profileSidebarBorderColor = ((String) in.readValue((String.class.getClassLoader())));
            instance.profileBackgroundTile = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.profileImageUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.createdAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.location = ((String) in.readValue((String.class.getClassLoader())));
            instance.followRequestSent = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.profileLinkColor = ((String) in.readValue((String.class.getClassLoader())));
            instance.isTranslator = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.idStr = ((String) in.readValue((String.class.getClassLoader())));
            instance.entities = ((Entities_) in.readValue((Entities_.class.getClassLoader())));
            instance.defaultProfile = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.contributorsEnabled = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.favouritesCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            instance.profileImageUrlHttps = ((String) in.readValue((String.class.getClassLoader())));
            instance.utcOffset = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.id = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.profileUseBackgroundImage = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.listedCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.profileTextColor = ((String) in.readValue((String.class.getClassLoader())));
            instance.lang = ((String) in.readValue((String.class.getClassLoader())));
            instance.followersCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance._protected = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.notifications = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.profileBackgroundImageUrlHttps = ((String) in.readValue((String.class.getClassLoader())));
            instance.profileBackgroundColor = ((String) in.readValue((String.class.getClassLoader())));
            instance.verified = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.geoEnabled = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.timeZone = ((String) in.readValue((String.class.getClassLoader())));
            instance.description = ((String) in.readValue((String.class.getClassLoader())));
            instance.defaultProfileImage = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.profileBackgroundImageUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.statusesCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.friendsCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.following = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.showAllInlineMedia = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.screenName = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public User[] newArray(int size) {
            return (new User[size]);
        }
    };
    @SerializedName("profile_sidebar_fill_color")
    @Expose
    private String profileSidebarFillColor;
    @SerializedName("profile_sidebar_border_color")
    @Expose
    private String profileSidebarBorderColor;
    @SerializedName("profile_background_tile")
    @Expose
    private Boolean profileBackgroundTile;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("profile_image_url")
    @Expose
    private String profileImageUrl;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("follow_request_sent")
    @Expose
    private Object followRequestSent;
    @SerializedName("profile_link_color")
    @Expose
    private String profileLinkColor;
    @SerializedName("is_translator")
    @Expose
    private Boolean isTranslator;
    @SerializedName("id_str")
    @Expose
    private String idStr;
    @SerializedName("entities")
    @Expose
    private Entities_ entities;
    @SerializedName("default_profile")
    @Expose
    private Boolean defaultProfile;
    @SerializedName("contributors_enabled")
    @Expose
    private Boolean contributorsEnabled;
    @SerializedName("favourites_count")
    @Expose
    private Integer favouritesCount;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("profile_image_url_https")
    @Expose
    private String profileImageUrlHttps;
    @SerializedName("utc_offset")
    @Expose
    private Integer utcOffset;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("profile_use_background_image")
    @Expose
    private Boolean profileUseBackgroundImage;
    @SerializedName("listed_count")
    @Expose
    private Integer listedCount;
    @SerializedName("profile_text_color")
    @Expose
    private String profileTextColor;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("followers_count")
    @Expose
    private Integer followersCount;
    @SerializedName("protected")
    @Expose
    private Boolean _protected;
    @SerializedName("notifications")
    @Expose
    private Object notifications;
    @SerializedName("profile_background_image_url_https")
    @Expose
    private String profileBackgroundImageUrlHttps;
    @SerializedName("profile_background_color")
    @Expose
    private String profileBackgroundColor;
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("geo_enabled")
    @Expose
    private Boolean geoEnabled;
    @SerializedName("time_zone")
    @Expose
    private String timeZone;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("default_profile_image")
    @Expose
    private Boolean defaultProfileImage;
    @SerializedName("profile_background_image_url")
    @Expose
    private String profileBackgroundImageUrl;
    @SerializedName("statuses_count")
    @Expose
    private Integer statusesCount;
    @SerializedName("friends_count")
    @Expose
    private Integer friendsCount;
    @SerializedName("following")
    @Expose
    private Object following;
    @SerializedName("show_all_inline_media")
    @Expose
    private Boolean showAllInlineMedia;
    @SerializedName("screen_name")
    @Expose
    private String screenName;

    public String getProfileSidebarFillColor() {
        return profileSidebarFillColor;
    }

    public void setProfileSidebarFillColor(String profileSidebarFillColor) {
        this.profileSidebarFillColor = profileSidebarFillColor;
    }

    public String getProfileSidebarBorderColor() {
        return profileSidebarBorderColor;
    }

    public void setProfileSidebarBorderColor(String profileSidebarBorderColor) {
        this.profileSidebarBorderColor = profileSidebarBorderColor;
    }

    public Boolean getProfileBackgroundTile() {
        return profileBackgroundTile;
    }

    public void setProfileBackgroundTile(Boolean profileBackgroundTile) {
        this.profileBackgroundTile = profileBackgroundTile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Object getFollowRequestSent() {
        return followRequestSent;
    }

    public void setFollowRequestSent(Object followRequestSent) {
        this.followRequestSent = followRequestSent;
    }

    public String getProfileLinkColor() {
        return profileLinkColor;
    }

    public void setProfileLinkColor(String profileLinkColor) {
        this.profileLinkColor = profileLinkColor;
    }

    public Boolean getIsTranslator() {
        return isTranslator;
    }

    public void setIsTranslator(Boolean isTranslator) {
        this.isTranslator = isTranslator;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public Entities_ getEntities() {
        return entities;
    }

    public void setEntities(Entities_ entities) {
        this.entities = entities;
    }

    public Boolean getDefaultProfile() {
        return defaultProfile;
    }

    public void setDefaultProfile(Boolean defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    public Boolean getContributorsEnabled() {
        return contributorsEnabled;
    }

    public void setContributorsEnabled(Boolean contributorsEnabled) {
        this.contributorsEnabled = contributorsEnabled;
    }

    public Integer getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(Integer favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProfileImageUrlHttps() {
        return profileImageUrlHttps;
    }

    public void setProfileImageUrlHttps(String profileImageUrlHttps) {
        this.profileImageUrlHttps = profileImageUrlHttps;
    }

    public Integer getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Integer utcOffset) {
        this.utcOffset = utcOffset;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getProfileUseBackgroundImage() {
        return profileUseBackgroundImage;
    }

    public void setProfileUseBackgroundImage(Boolean profileUseBackgroundImage) {
        this.profileUseBackgroundImage = profileUseBackgroundImage;
    }

    public Integer getListedCount() {
        return listedCount;
    }

    public void setListedCount(Integer listedCount) {
        this.listedCount = listedCount;
    }

    public String getProfileTextColor() {
        return profileTextColor;
    }

    public void setProfileTextColor(String profileTextColor) {
        this.profileTextColor = profileTextColor;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public Boolean getProtected() {
        return _protected;
    }

    public void setProtected(Boolean _protected) {
        this._protected = _protected;
    }

    public Object getNotifications() {
        return notifications;
    }

    public void setNotifications(Object notifications) {
        this.notifications = notifications;
    }

    public String getProfileBackgroundImageUrlHttps() {
        return profileBackgroundImageUrlHttps;
    }

    public void setProfileBackgroundImageUrlHttps(String profileBackgroundImageUrlHttps) {
        this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
    }

    public String getProfileBackgroundColor() {
        return profileBackgroundColor;
    }

    public void setProfileBackgroundColor(String profileBackgroundColor) {
        this.profileBackgroundColor = profileBackgroundColor;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Boolean getGeoEnabled() {
        return geoEnabled;
    }

    public void setGeoEnabled(Boolean geoEnabled) {
        this.geoEnabled = geoEnabled;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDefaultProfileImage() {
        return defaultProfileImage;
    }

    public void setDefaultProfileImage(Boolean defaultProfileImage) {
        this.defaultProfileImage = defaultProfileImage;
    }

    public String getProfileBackgroundImageUrl() {
        return profileBackgroundImageUrl;
    }

    public void setProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
        this.profileBackgroundImageUrl = profileBackgroundImageUrl;
    }

    public Integer getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(Integer statusesCount) {
        this.statusesCount = statusesCount;
    }

    public Integer getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(Integer friendsCount) {
        this.friendsCount = friendsCount;
    }

    public Object getFollowing() {
        return following;
    }

    public void setFollowing(Object following) {
        this.following = following;
    }

    public Boolean getShowAllInlineMedia() {
        return showAllInlineMedia;
    }

    public void setShowAllInlineMedia(Boolean showAllInlineMedia) {
        this.showAllInlineMedia = showAllInlineMedia;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(profileSidebarFillColor);
        dest.writeValue(profileSidebarBorderColor);
        dest.writeValue(profileBackgroundTile);
        dest.writeValue(name);
        dest.writeValue(profileImageUrl);
        dest.writeValue(createdAt);
        dest.writeValue(location);
        dest.writeValue(followRequestSent);
        dest.writeValue(profileLinkColor);
        dest.writeValue(isTranslator);
        dest.writeValue(idStr);
        dest.writeValue(entities);
        dest.writeValue(defaultProfile);
        dest.writeValue(contributorsEnabled);
        dest.writeValue(favouritesCount);
        dest.writeValue(url);
        dest.writeValue(profileImageUrlHttps);
        dest.writeValue(utcOffset);
        dest.writeValue(id);
        dest.writeValue(profileUseBackgroundImage);
        dest.writeValue(listedCount);
        dest.writeValue(profileTextColor);
        dest.writeValue(lang);
        dest.writeValue(followersCount);
        dest.writeValue(_protected);
        dest.writeValue(notifications);
        dest.writeValue(profileBackgroundImageUrlHttps);
        dest.writeValue(profileBackgroundColor);
        dest.writeValue(verified);
        dest.writeValue(geoEnabled);
        dest.writeValue(timeZone);
        dest.writeValue(description);
        dest.writeValue(defaultProfileImage);
        dest.writeValue(profileBackgroundImageUrl);
        dest.writeValue(statusesCount);
        dest.writeValue(friendsCount);
        dest.writeValue(following);
        dest.writeValue(showAllInlineMedia);
        dest.writeValue(screenName);
    }

    public int describeContents() {
        return 0;
    }
}
