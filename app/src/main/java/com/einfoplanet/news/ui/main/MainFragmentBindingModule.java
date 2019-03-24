package com.einfoplanet.news.ui.main;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import com.einfoplanet.news.ui.detail.DetailsFragment;
import com.einfoplanet.news.ui.list.ListFragment;

@Module
public abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract ListFragment provideListFragment();

    @ContributesAndroidInjector
    abstract DetailsFragment provideDetailsFragment();
}
