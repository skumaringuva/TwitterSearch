package com.sheshu.twittersearch.web;


import com.google.gson.annotations.SerializedName;


public class RetweetedStatus{

	@SerializedName("extended_entities")
	private ExtendedEntities extendedEntities;

	@SerializedName("metadata")
	private Metadata metadata;

	@SerializedName("in_reply_to_status_id_str")
	private Object inReplyToStatusIdStr;

	@SerializedName("in_reply_to_status_id")
	private Object inReplyToStatusId;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("in_reply_to_user_id_str")
	private Object inReplyToUserIdStr;

	@SerializedName("source")
	private String source;

	@SerializedName("retweet_count")
	private int retweetCount;

	@SerializedName("retweeted")
	private boolean retweeted;

	@SerializedName("geo")
	private Object geo;

	@SerializedName("in_reply_to_screen_name")
	private Object inReplyToScreenName;

	@SerializedName("is_quote_status")
	private boolean isQuoteStatus;

	@SerializedName("id_str")
	private String idStr;

	@SerializedName("in_reply_to_user_id")
	private Object inReplyToUserId;

	@SerializedName("favorite_count")
	private int favoriteCount;

	@SerializedName("id")
	private long id;

	@SerializedName("text")
	private String text;

	@SerializedName("place")
	private Object place;

	@SerializedName("lang")
	private String lang;

	@SerializedName("favorited")
	private boolean favorited;

	@SerializedName("possibly_sensitive")
	private boolean possiblySensitive;

	@SerializedName("coordinates")
	private Object coordinates;

	@SerializedName("truncated")
	private boolean truncated;

	@SerializedName("entities")
	private Entities entities;

	@SerializedName("contributors")
	private Object contributors;

	@SerializedName("user")
	private User user;

	public void setExtendedEntities(ExtendedEntities extendedEntities){
		this.extendedEntities = extendedEntities;
	}

	public ExtendedEntities getExtendedEntities(){
		return extendedEntities;
	}

	public void setMetadata(Metadata metadata){
		this.metadata = metadata;
	}

	public Metadata getMetadata(){
		return metadata;
	}

	public void setInReplyToStatusIdStr(Object inReplyToStatusIdStr){
		this.inReplyToStatusIdStr = inReplyToStatusIdStr;
	}

	public Object getInReplyToStatusIdStr(){
		return inReplyToStatusIdStr;
	}

	public void setInReplyToStatusId(Object inReplyToStatusId){
		this.inReplyToStatusId = inReplyToStatusId;
	}

	public Object getInReplyToStatusId(){
		return inReplyToStatusId;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setInReplyToUserIdStr(Object inReplyToUserIdStr){
		this.inReplyToUserIdStr = inReplyToUserIdStr;
	}

	public Object getInReplyToUserIdStr(){
		return inReplyToUserIdStr;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setRetweetCount(int retweetCount){
		this.retweetCount = retweetCount;
	}

	public int getRetweetCount(){
		return retweetCount;
	}

	public void setRetweeted(boolean retweeted){
		this.retweeted = retweeted;
	}

	public boolean isRetweeted(){
		return retweeted;
	}

	public void setGeo(Object geo){
		this.geo = geo;
	}

	public Object getGeo(){
		return geo;
	}

	public void setInReplyToScreenName(Object inReplyToScreenName){
		this.inReplyToScreenName = inReplyToScreenName;
	}

	public Object getInReplyToScreenName(){
		return inReplyToScreenName;
	}

	public void setIsQuoteStatus(boolean isQuoteStatus){
		this.isQuoteStatus = isQuoteStatus;
	}

	public boolean isIsQuoteStatus(){
		return isQuoteStatus;
	}

	public void setIdStr(String idStr){
		this.idStr = idStr;
	}

	public String getIdStr(){
		return idStr;
	}

	public void setInReplyToUserId(Object inReplyToUserId){
		this.inReplyToUserId = inReplyToUserId;
	}

	public Object getInReplyToUserId(){
		return inReplyToUserId;
	}

	public void setFavoriteCount(int favoriteCount){
		this.favoriteCount = favoriteCount;
	}

	public int getFavoriteCount(){
		return favoriteCount;
	}

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return id;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setPlace(Object place){
		this.place = place;
	}

	public Object getPlace(){
		return place;
	}

	public void setLang(String lang){
		this.lang = lang;
	}

	public String getLang(){
		return lang;
	}

	public void setFavorited(boolean favorited){
		this.favorited = favorited;
	}

	public boolean isFavorited(){
		return favorited;
	}

	public void setPossiblySensitive(boolean possiblySensitive){
		this.possiblySensitive = possiblySensitive;
	}

	public boolean isPossiblySensitive(){
		return possiblySensitive;
	}

	public void setCoordinates(Object coordinates){
		this.coordinates = coordinates;
	}

	public Object getCoordinates(){
		return coordinates;
	}

	public void setTruncated(boolean truncated){
		this.truncated = truncated;
	}

	public boolean isTruncated(){
		return truncated;
	}

	public void setEntities(Entities entities){
		this.entities = entities;
	}

	public Entities getEntities(){
		return entities;
	}

	public void setContributors(Object contributors){
		this.contributors = contributors;
	}

	public Object getContributors(){
		return contributors;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	@Override
 	public String toString(){
		return 
			"RetweetedStatus{" + 
			"extended_entities = '" + extendedEntities + '\'' + 
			",metadata = '" + metadata + '\'' + 
			",in_reply_to_status_id_str = '" + inReplyToStatusIdStr + '\'' + 
			",in_reply_to_status_id = '" + inReplyToStatusId + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",in_reply_to_user_id_str = '" + inReplyToUserIdStr + '\'' + 
			",source = '" + source + '\'' + 
			",retweet_count = '" + retweetCount + '\'' + 
			",retweeted = '" + retweeted + '\'' + 
			",geo = '" + geo + '\'' + 
			",in_reply_to_screen_name = '" + inReplyToScreenName + '\'' + 
			",is_quote_status = '" + isQuoteStatus + '\'' + 
			",id_str = '" + idStr + '\'' + 
			",in_reply_to_user_id = '" + inReplyToUserId + '\'' + 
			",favorite_count = '" + favoriteCount + '\'' + 
			",id = '" + id + '\'' + 
			",text = '" + text + '\'' + 
			",place = '" + place + '\'' + 
			",lang = '" + lang + '\'' + 
			",favorited = '" + favorited + '\'' + 
			",possibly_sensitive = '" + possiblySensitive + '\'' + 
			",coordinates = '" + coordinates + '\'' + 
			",truncated = '" + truncated + '\'' + 
			",entities = '" + entities + '\'' + 
			",contributors = '" + contributors + '\'' + 
			",user = '" + user + '\'' + 
			"}";
		}
}