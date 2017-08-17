package com.sheshu.twittersearch.web;


import com.google.gson.annotations.SerializedName;


public class Sizes{

	@SerializedName("small")
	private Small small;

	@SerializedName("large")
	private Large large;

	@SerializedName("thumb")
	private Thumb thumb;

	@SerializedName("medium")
	private Medium medium;

	public void setSmall(Small small){
		this.small = small;
	}

	public Small getSmall(){
		return small;
	}

	public void setLarge(Large large){
		this.large = large;
	}

	public Large getLarge(){
		return large;
	}

	public void setThumb(Thumb thumb){
		this.thumb = thumb;
	}

	public Thumb getThumb(){
		return thumb;
	}

	public void setMedium(Medium medium){
		this.medium = medium;
	}

	public Medium getMedium(){
		return medium;
	}

	@Override
 	public String toString(){
		return 
			"Sizes{" + 
			"small = '" + small + '\'' + 
			",large = '" + large + '\'' + 
			",thumb = '" + thumb + '\'' + 
			",medium = '" + medium + '\'' + 
			"}";
		}
}