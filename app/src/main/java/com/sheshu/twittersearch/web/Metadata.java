package com.sheshu.twittersearch.web;


import com.google.gson.annotations.SerializedName;


public class Metadata{

	@SerializedName("result_type")
	private String resultType;

	@SerializedName("iso_language_code")
	private String isoLanguageCode;

	public void setResultType(String resultType){
		this.resultType = resultType;
	}

	public String getResultType(){
		return resultType;
	}

	public void setIsoLanguageCode(String isoLanguageCode){
		this.isoLanguageCode = isoLanguageCode;
	}

	public String getIsoLanguageCode(){
		return isoLanguageCode;
	}

	@Override
 	public String toString(){
		return 
			"Metadata{" + 
			"result_type = '" + resultType + '\'' + 
			",iso_language_code = '" + isoLanguageCode + '\'' + 
			"}";
		}
}