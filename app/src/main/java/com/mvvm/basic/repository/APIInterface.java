package com.mvvm.basic.repository;

import com.google.gson.JsonElement;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface APIInterface {
    @FormUrlEncoded
    @POST
    Call<ResponseBody> login(@Url String url, @Field("pass") String mobileNumber);
}


