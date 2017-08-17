package com.sheshu.twittersearch.web;


import com.google.gson.annotations.SerializedName;


public class JsonMember{

	@SerializedName("metadata")
	private Metadata metadata;

	@SerializedName("in_reply_to_status_id_str")
	private Object inReplyToStatusIdStr;

	@SerializedName("in_reply_to_status_id")
	private Object inReplyToStatusId;

	@SerializedName("coordinates")
	private Object coordinates;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("truncated")
	private boolean truncated;

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

	@SerializedName("entities")
	private Entities entities;

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

	@SerializedName("contributors")
	private Object contributors;

	@SerializedName("lang")
	private String lang;

	@SerializedName("user")
	private User user;

	@SerializedName("favorited")
	private boolean favorited;

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

	public void setCoordinates(Object coordinates){
		this.coordinates = coordinates;
	}

	public Object getCoordinates(){
		return coordinates;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setTruncated(boolean truncated){
		this.truncated = truncated;
	}

	public boolean isTruncated(){
		return truncated;
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

	public void setEntities(Entities entities){
		this.entities = entities;
	}

	public Entities getEntities(){
		return entities;
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

	public void setContributors(Object contributors){
		this.contributors = contributors;
	}

	public Object getContributors(){
		return contributors;
	}

	public void setLang(String lang){
		this.lang = lang;
	}

	public String getLang(){
		return lang;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setFavorited(boolean favorited){
		this.favorited = favorited;
	}

	public boolean isFavorited(){
		return favorited;
	}

	@Override
 	public String toString(){
		return 
			"JsonMember{" + 
			"metadata = '" + metadata + '\'' + 
			",in_reply_to_status_id_str = '" + inReplyToStatusIdStr + '\'' + 
			",in_reply_to_status_id = '" + inReplyToStatusId + '\'' + 
			",coordinates = '" + coordinates + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",truncated = '" + truncated + '\'' + 
			",in_reply_to_user_id_str = '" + inReplyToUserIdStr + '\'' + 
			",source = '" + source + '\'' + 
			",retweet_count = '" + retweetCount + '\'' + 
			",retweeted = '" + retweeted + '\'' + 
			",geo = '" + geo + '\'' + 
			",in_reply_to_screen_name = '" + inReplyToScreenName + '\'' + 
			",is_quote_status = '" + isQuoteStatus + '\'' + 
			",entities = '" + entities + '\'' + 
			",id_str = '" + idStr + '\'' + 
			",in_reply_to_user_id = '" + inReplyToUserId + '\'' + 
			",favorite_count = '" + favoriteCount + '\'' + 
			",id = '" + id + '\'' + 
			",text = '" + text + '\'' + 
			",place = '" + place + '\'' + 
			",contributors = '" + contributors + '\'' + 
			",lang = '" + lang + '\'' + 
			",user = '" + user + '\'' + 
			",favorited = '" + favorited + '\'' + 
			"}";
		}
}