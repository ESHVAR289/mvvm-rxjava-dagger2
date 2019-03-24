package com.einfoplanet.news.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import com.einfoplanet.news.ui.main.MainActivity;
import com.einfoplanet.news.ui.main.MainFragmentBindingModule;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {MainFragmentBindingModule.class})
    abstract MainActivity bindMainActivity();
}
