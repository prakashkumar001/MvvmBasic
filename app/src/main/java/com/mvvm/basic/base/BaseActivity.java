package com.mvvm.basic.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.mvvm.basic.R;

public class BaseActivity extends AppCompatActivity {

    public void loadFragment(Fragment fragment, boolean addBacktoStack) {

        if (!fragment.isAdded()) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            String fragmentName = fragment.getClass().getName();

            if (addBacktoStack) {
                fragmentTransaction.add(R.id.frame, fragment).addToBackStack(fragmentName);
            } else {
                fragmentTransaction.replace(R.id.frame, fragment);

            }
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fragmentTransaction.commit();
        }


    }
}
