package com.sheshu.twittersearch.controller;

import com.sheshu.twittersearch.web.StatusesItem;

import java.util.List;

/**
 * Created by Sheshu on 8/6/17.
 */
public interface TwitterNotifier {
    public void onAuthenticated(boolean isSuccess);
    public void searchResults(List<StatusesItem> statuses);
    public void searchError();
}
