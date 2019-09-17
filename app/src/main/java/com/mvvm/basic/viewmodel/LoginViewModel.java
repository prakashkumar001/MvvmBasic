package com.mvvm.basic.viewmodel;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.MutableLiveData;

import com.mvvm.basic.model.LoginModel;
import com.mvvm.basic.repository.Repository;
import com.mvvm.basic.repository.ResultListener;

import io.reactivex.disposables.CompositeDisposable;

public class LoginViewModel extends BaseObservable implements ResultListener {

    private String successMessage = "Login was successful";
    private String errorMessage = "Email or Password not valid";

    private Repository repository;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final MutableLiveData<String> responseLiveData = new MutableLiveData<>();

    public LoginModel loginModel;

    @Bindable
    public String toastMessage = null;


    public String getHintEmail() {
        return hintEmail;
    }

    public void setHintEmail(String hintEmail) {
        this.hintEmail = hintEmail;
        notifyPropertyChanged(BR.hintEmail);
    }

    public String getHintPassword() {
        return hintPassword;
    }

    public void setHintPassword(String hintPassword) {
        this.hintPassword = hintPassword;
    }

    @Bindable
    public String hintEmail = "Please Enter Email";


    @Bindable
    public String hintPassword = "Please Enter Password";


    public String getToastMessage() {
        return toastMessage;
    }


    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }



    public LoginViewModel(Repository repository) {
        loginModel = new LoginModel("", "");
        this.repository = repository;
    }



    public void setTxtEmailId(String email) {
        loginModel.setEmail(email);
        notifyPropertyChanged(BR.txtEmailId);
    }


    @Bindable
    public String getTxtEmailId() {

        return loginModel.getEmail();
    }

    public void setTxtPassword(String password) {
        loginModel.setPassword(password);
        notifyPropertyChanged(BR.txtPassword);
    }

    @Bindable
    public String getTxtPassword() {

        return loginModel.getPassword();
    }


    public void onSubmitLogin() {
        if (isInputDataValid()) {
            setToastMessage(successMessage);

        } else {
            setToastMessage(errorMessage);

        }
    }

    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getTxtEmailId()) && Patterns.EMAIL_ADDRESS.matcher(getTxtEmailId()).matches() && getTxtPassword().length() > 5;
    }


    /*
     * method to call normal login api with $(mobileNumber + password)
     * */
    public MutableLiveData<String> hitApi(String url, String password) {

        repository.onCallRequest(url,password,this);

        return responseLiveData;

    }

    @Override
    public void onSuccess(String response) {

        responseLiveData.setValue(response);

    }

    @Override
    public void onFailure(String error) {

    }

   /* @Override
    protected void onCleared() {
        disposables.clear();
    }*/

}
