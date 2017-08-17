package com.sheshu.twittersearch.web;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class UrlsItem{

	@SerializedName("display_url")
	private String displayUrl;

	@SerializedName("indices")
	private List<Integer> indices;

	@SerializedName("expanded_url")
	private String expandedUrl;

	@SerializedName("url")
	private String url;

	public void setDisplayUrl(String displayUrl){
		this.displayUrl = displayUrl;
	}

	public String getDisplayUrl(){
		return displayUrl;
	}

	public void setIndices(List<Integer> indices){
		this.indices = indices;
	}

	public List<Integer> getIndices(){
		return indices;
	}

	public void setExpandedUrl(String expandedUrl){
		this.expandedUrl = expandedUrl;
	}

	public String getExpandedUrl(){
		return expandedUrl;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"UrlsItem{" + 
			"display_url = '" + displayUrl + '\'' + 
			",indices = '" + indices + '\'' + 
			",expanded_url = '" + expandedUrl + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}