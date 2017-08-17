package com.sheshu.twittersearch.web;


import com.google.gson.annotations.SerializedName;


public class Small{

	@SerializedName("w")
	private int W;

	@SerializedName("h")
	private int H;

	@SerializedName("resize")
	private String resize;

	public void setW(int W){
		this.W = W;
	}

	public int getW(){
		return W;
	}

	public void setH(int H){
		this.H = H;
	}

	public int getH(){
		return H;
	}

	public void setResize(String resize){
		this.resize = resize;
	}

	public String getResize(){
		return resize;
	}

	@Override
 	public String toString(){
		return 
			"Small{" + 
			"w = '" + W + '\'' + 
			",h = '" + H + '\'' + 
			",resize = '" + resize + '\'' + 
			"}";
		}
}