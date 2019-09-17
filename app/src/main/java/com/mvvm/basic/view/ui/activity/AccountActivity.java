package com.mvvm.basic.view.ui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mvvm.basic.R;
import com.mvvm.basic.base.BaseActivity;
import com.mvvm.basic.view.ui.fragment.Login;

public class AccountActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        showFragment();

    }

    void showFragment()
    {
        Login login=new Login();
        loadFragment(login,false);
    }

}
