package com.mvvm.basic.repository;

public interface ResultListener {
    public void onSuccess(String response);
    public void onFailure(String error);
}
