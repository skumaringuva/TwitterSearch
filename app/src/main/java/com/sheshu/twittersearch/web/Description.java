package com.sheshu.twittersearch.web;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class Description{

	@SerializedName("urls")
	private List<Object> urls;

	public void setUrls(List<Object> urls){
		this.urls = urls;
	}

	public List<Object> getUrls(){
		return urls;
	}

	@Override
 	public String toString(){
		return 
			"Description{" + 
			"urls = '" + urls + '\'' + 
			"}";
		}
}