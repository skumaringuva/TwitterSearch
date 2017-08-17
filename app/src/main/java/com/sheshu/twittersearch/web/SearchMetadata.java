package com.sheshu.twittersearch.web;


import com.google.gson.annotations.SerializedName;


public class SearchMetadata{

	@SerializedName("max_id_str")
	private String maxIdStr;

	@SerializedName("next_results")
	private String nextResults;

	@SerializedName("since_id_str")
	private String sinceIdStr;

	@SerializedName("query")
	private String query;

	@SerializedName("count")
	private int count;

	@SerializedName("max_id")
	private long maxId;

	@SerializedName("since_id")
	private int sinceId;

	@SerializedName("completed_in")
	private double completedIn;

	@SerializedName("refresh_url")
	private String refreshUrl;

	public void setMaxIdStr(String maxIdStr){
		this.maxIdStr = maxIdStr;
	}

	public String getMaxIdStr(){
		return maxIdStr;
	}

	public void setNextResults(String nextResults){
		this.nextResults = nextResults;
	}

	public String getNextResults(){
		return nextResults;
	}

	public void setSinceIdStr(String sinceIdStr){
		this.sinceIdStr = sinceIdStr;
	}

	public String getSinceIdStr(){
		return sinceIdStr;
	}

	public void setQuery(String query){
		this.query = query;
	}

	public String getQuery(){
		return query;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setMaxId(long maxId){
		this.maxId = maxId;
	}

	public long getMaxId(){
		return maxId;
	}

	public void setSinceId(int sinceId){
		this.sinceId = sinceId;
	}

	public int getSinceId(){
		return sinceId;
	}

	public void setCompletedIn(double completedIn){
		this.completedIn = completedIn;
	}

	public double getCompletedIn(){
		return completedIn;
	}

	public void setRefreshUrl(String refreshUrl){
		this.refreshUrl = refreshUrl;
	}

	public String getRefreshUrl(){
		return refreshUrl;
	}

	@Override
 	public String toString(){
		return 
			"SearchMetadata{" + 
			"max_id_str = '" + maxIdStr + '\'' + 
			",next_results = '" + nextResults + '\'' + 
			",since_id_str = '" + sinceIdStr + '\'' + 
			",query = '" + query + '\'' + 
			",count = '" + count + '\'' + 
			",max_id = '" + maxId + '\'' + 
			",since_id = '" + sinceId + '\'' + 
			",completed_in = '" + completedIn + '\'' + 
			",refresh_url = '" + refreshUrl + '\'' + 
			"}";
		}
}