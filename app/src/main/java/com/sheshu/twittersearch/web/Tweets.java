package com.sheshu.twittersearch.web;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Tweets{

	@SerializedName("")
	private JsonMember jsonMember;

	@SerializedName("statuses")
	private List<StatusesItem> statuses;

	@SerializedName("search_metadata")
	private SearchMetadata searchMetadata;

	public void setJsonMember(JsonMember jsonMember){
		this.jsonMember = jsonMember;
	}

	public JsonMember getJsonMember(){
		return jsonMember;
	}

	public void setStatuses(List<StatusesItem> statuses){
		this.statuses = statuses;
	}

	public List<StatusesItem> getStatuses(){
		return statuses;
	}

	public void setSearchMetadata(SearchMetadata searchMetadata){
		this.searchMetadata = searchMetadata;
	}

	public SearchMetadata getSearchMetadata(){
		return searchMetadata;
	}

	@Override
 	public String toString(){
		return 
			"Tweets{" + 
			" = '" + jsonMember + '\'' + 
			",statuses = '" + statuses + '\'' + 
			",search_metadata = '" + searchMetadata + '\'' + 
			"}";
		}
}