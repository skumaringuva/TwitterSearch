package com.sheshu.twittersearch.web;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Url{

	@SerializedName("urls")
	private List<UrlsItem> urls;

	public void setUrls(List<UrlsItem> urls){
		this.urls = urls;
	}

	public List<UrlsItem> getUrls(){
		return urls;
	}

	@Override
 	public String toString(){
		return 
			"Url{" + 
			"urls = '" + urls + '\'' + 
			"}";
		}
}