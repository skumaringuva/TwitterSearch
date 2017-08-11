package com.sheshu.twittersearch.web;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata implements Parcelable {
    public final static Creator<Metadata> CREATOR = new Creator<Metadata>() {
        @SuppressWarnings({
                "unchecked"
        })
        public Metadata createFromParcel(Parcel in) {
            Metadata instance = new Metadata();
            instance.isoLanguageCode = ((String) in.readValue((String.class.getClassLoader())));
            instance.resultType = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Metadata[] newArray(int size) {
            return (new Metadata[size]);
        }
    };
    @SerializedName("iso_language_code")
    @Expose
    private String isoLanguageCode;
    @SerializedName("result_type")
    @Expose
    private String resultType;

    public String getIsoLanguageCode() {
        return isoLanguageCode;
    }

    public void setIsoLanguageCode(String isoLanguageCode) {
        this.isoLanguageCode = isoLanguageCode;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(isoLanguageCode);
        dest.writeValue(resultType);
    }

    public int describeContents() {
        return 0;
    }
}
