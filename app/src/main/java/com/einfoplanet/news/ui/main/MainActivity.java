package com.einfoplanet.news.ui.main;

import android.os.Bundle;

import com.einfoplanet.news.R;
import com.einfoplanet.news.base.BaseActivity;
import com.einfoplanet.news.ui.list.ListFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().add(R.id.screenContainer, new ListFragment()).commit();
    }
}
