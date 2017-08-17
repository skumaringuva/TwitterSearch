package com.sheshu.twittersearch.web;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class UserMentionsItem{

	@SerializedName("indices")
	private List<Integer> indices;

	@SerializedName("screen_name")
	private String screenName;

	@SerializedName("id_str")
	private String idStr;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private long id;

	public void setIndices(List<Integer> indices){
		this.indices = indices;
	}

	public List<Integer> getIndices(){
		return indices;
	}

	public void setScreenName(String screenName){
		this.screenName = screenName;
	}

	public String getScreenName(){
		return screenName;
	}

	public void setIdStr(String idStr){
		this.idStr = idStr;
	}

	public String getIdStr(){
		return idStr;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"UserMentionsItem{" + 
			"indices = '" + indices + '\'' + 
			",screen_name = '" + screenName + '\'' + 
			",id_str = '" + idStr + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}