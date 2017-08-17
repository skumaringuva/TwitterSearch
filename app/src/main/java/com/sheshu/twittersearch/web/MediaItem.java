package com.sheshu.twittersearch.web;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class MediaItem{

	@SerializedName("display_url")
	private String displayUrl;

	@SerializedName("source_user_id")
	private long sourceUserId;

	@SerializedName("type")
	private String type;

	@SerializedName("media_url")
	private String mediaUrl;

	@SerializedName("source_status_id")
	private long sourceStatusId;

	@SerializedName("url")
	private String url;

	@SerializedName("indices")
	private List<Integer> indices;

	@SerializedName("sizes")
	private Sizes sizes;

	@SerializedName("id_str")
	private String idStr;

	@SerializedName("expanded_url")
	private String expandedUrl;

	@SerializedName("source_status_id_str")
	private String sourceStatusIdStr;

	@SerializedName("media_url_https")
	private String mediaUrlHttps;

	@SerializedName("id")
	private long id;

	@SerializedName("source_user_id_str")
	private String sourceUserIdStr;

	public void setDisplayUrl(String displayUrl){
		this.displayUrl = displayUrl;
	}

	public String getDisplayUrl(){
		return displayUrl;
	}

	public void setSourceUserId(long sourceUserId){
		this.sourceUserId = sourceUserId;
	}

	public long getSourceUserId(){
		return sourceUserId;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setMediaUrl(String mediaUrl){
		this.mediaUrl = mediaUrl;
	}

	public String getMediaUrl(){
		return mediaUrl;
	}

	public void setSourceStatusId(long sourceStatusId){
		this.sourceStatusId = sourceStatusId;
	}

	public long getSourceStatusId(){
		return sourceStatusId;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setIndices(List<Integer> indices){
		this.indices = indices;
	}

	public List<Integer> getIndices(){
		return indices;
	}

	public void setSizes(Sizes sizes){
		this.sizes = sizes;
	}

	public Sizes getSizes(){
		return sizes;
	}

	public void setIdStr(String idStr){
		this.idStr = idStr;
	}

	public String getIdStr(){
		return idStr;
	}

	public void setExpandedUrl(String expandedUrl){
		this.expandedUrl = expandedUrl;
	}

	public String getExpandedUrl(){
		return expandedUrl;
	}

	public void setSourceStatusIdStr(String sourceStatusIdStr){
		this.sourceStatusIdStr = sourceStatusIdStr;
	}

	public String getSourceStatusIdStr(){
		return sourceStatusIdStr;
	}

	public void setMediaUrlHttps(String mediaUrlHttps){
		this.mediaUrlHttps = mediaUrlHttps;
	}

	public String getMediaUrlHttps(){
		return mediaUrlHttps;
	}

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return id;
	}

	public void setSourceUserIdStr(String sourceUserIdStr){
		this.sourceUserIdStr = sourceUserIdStr;
	}

	public String getSourceUserIdStr(){
		return sourceUserIdStr;
	}

	@Override
 	public String toString(){
		return 
			"MediaItem{" + 
			"display_url = '" + displayUrl + '\'' + 
			",source_user_id = '" + sourceUserId + '\'' + 
			",type = '" + type + '\'' + 
			",media_url = '" + mediaUrl + '\'' + 
			",source_status_id = '" + sourceStatusId + '\'' + 
			",url = '" + url + '\'' + 
			",indices = '" + indices + '\'' + 
			",sizes = '" + sizes + '\'' + 
			",id_str = '" + idStr + '\'' + 
			",expanded_url = '" + expandedUrl + '\'' + 
			",source_status_id_str = '" + sourceStatusIdStr + '\'' + 
			",media_url_https = '" + mediaUrlHttps + '\'' + 
			",id = '" + id + '\'' + 
			",source_user_id_str = '" + sourceUserIdStr + '\'' + 
			"}";
		}
}