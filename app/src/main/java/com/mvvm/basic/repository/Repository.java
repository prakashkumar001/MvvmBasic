package com.mvvm.basic.repository;

import com.google.gson.JsonElement;

import java.io.IOException;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    APIInterface apiInterface;
    public Repository()
    {
        apiInterface= APIClient.getRetrofitInstance().create(APIInterface.class);

    }



    public void onCallRequest(String url, String mobile, final ResultListener listener)
    {
        Call<ResponseBody> call=apiInterface.login(url,mobile);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    listener.onSuccess(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                listener.onFailure(t.getMessage());
            }
        });

    }


}
