package com.sheshu.twittersearch.web;
/**
 * Created by Sheshu on 8/6/17.
 */

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Api interface to retrofit call.
 */
public interface TwitterApi {
    @Headers({
            "Host: api.twitter.com",
            "Accept: application/json",
           /* "User-Agent: TwitterSearchSheshu",*/
            "Content-Type: application/json;charset=utf-8",
            "User-Agent: Mozilla/5.0 ( compatible )",
            "Accept: */*"
    })
    @GET("/1.1/search/tweets.json?")
    Call<Tweets> getSearchResults(@Header("Authorization") String token, @Query("q") String searchKey);
}