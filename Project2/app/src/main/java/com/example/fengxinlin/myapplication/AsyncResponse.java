package com.example.fengxinlin.myapplication;

import java.util.List;

/**
 * Created by fengxinlin on 11/16/16.
 */
public interface AsyncResponse {
    void onTaskComplete(List<Movie> result);
}
