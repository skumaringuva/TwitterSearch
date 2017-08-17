package com.sheshu.twittersearch.web;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Entities{

	@SerializedName("urls")
	private List<Object> urls;

	@SerializedName("hashtags")
	private List<Object> hashtags;

	@SerializedName("media")
	private List<MediaItem> media;

	@SerializedName("user_mentions")
	private List<UserMentionsItem> userMentions;

	@SerializedName("symbols")
	private List<Object> symbols;

	public void setUrls(List<Object> urls){
		this.urls = urls;
	}

	public List<Object> getUrls(){
		return urls;
	}

	public void setHashtags(List<Object> hashtags){
		this.hashtags = hashtags;
	}

	public List<Object> getHashtags(){
		return hashtags;
	}

	public void setMedia(List<MediaItem> media){
		this.media = media;
	}

	public List<MediaItem> getMedia(){
		return media;
	}

	public void setUserMentions(List<UserMentionsItem> userMentions){
		this.userMentions = userMentions;
	}

	public List<UserMentionsItem> getUserMentions(){
		return userMentions;
	}

	public void setSymbols(List<Object> symbols){
		this.symbols = symbols;
	}

	public List<Object> getSymbols(){
		return symbols;
	}

	@Override
 	public String toString(){
		return 
			"Entities{" + 
			"urls = '" + urls + '\'' + 
			",hashtags = '" + hashtags + '\'' + 
			",media = '" + media + '\'' + 
			",user_mentions = '" + userMentions + '\'' + 
			",symbols = '" + symbols + '\'' + 
			"}";
		}
}