package com.example.alien.course04task02.ui.filmList;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.ui.common.BaseViewModel;

public class ListAllViewModel extends BaseViewModel {

    public ListAllViewModel(IRepository repository) {
        super(repository);
        mFilmList.setValue(mRepository.getAll());
    }

}
