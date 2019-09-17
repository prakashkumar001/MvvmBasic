package com.mvvm.basic.view.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.google.gson.JsonElement;
import com.mvvm.basic.R;
import com.mvvm.basic.databinding.FragmentLoginBinding;
import com.mvvm.basic.repository.APIInterface;
import com.mvvm.basic.repository.Repository;
import com.mvvm.basic.viewmodel.LoginViewModel;


public class Login extends Fragment {

    public static FragmentLoginBinding binding;
    LoginViewModel loginViewModel;
    Repository repository;
    APIInterface apiInterface;
    public static Login login;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        login=this;
        repository=new Repository();
        loginViewModel = new LoginViewModel(repository);
        binding.setLoginViewModel(loginViewModel);
        binding.executePendingBindings();
        return binding.getRoot();
    }

    @BindingAdapter({"toastMessage"})
    public static void displayToast(View view,String message)
    {
        if(message!=null)
        {
            binding.getLoginViewModel().hitApi("https://organicfoodsandcafe.com/cafe_app/wp-content/themes/tuscany/app/login.php","").observe(login,new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    Toast.makeText(login.getActivity(),s,Toast.LENGTH_SHORT).show();
                }
            });
           //

        }
    }

}
