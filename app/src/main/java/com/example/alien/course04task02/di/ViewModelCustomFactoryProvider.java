package com.example.alien.course04task02.di;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.ui.filmList.ViewModelCustomFactory;

import javax.inject.Inject;
import javax.inject.Provider;

public class ViewModelCustomFactoryProvider implements Provider<ViewModelCustomFactory> {

    protected IRepository mRepository;

    @Inject
    public ViewModelCustomFactoryProvider(IRepository mRepository) {
        this.mRepository = mRepository;
    }

    @Override
    public ViewModelCustomFactory get() {
        return new ViewModelCustomFactory(mRepository);
    }
}
