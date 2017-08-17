package com.sheshu.twittersearch.web;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ExtendedEntities{

	@SerializedName("media")
	private List<MediaItem> media;

	public void setMedia(List<MediaItem> media){
		this.media = media;
	}

	public List<MediaItem> getMedia(){
		return media;
	}

	@Override
 	public String toString(){
		return 
			"ExtendedEntities{" + 
			"media = '" + media + '\'' + 
			"}";
		}
}