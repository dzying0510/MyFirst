package com.coolweather.my.presenter.impl;

import com.coolweather.my.model.impl.MainAModelImpl;
import com.coolweather.my.model.inter.IMainAModel;
import com.coolweather.my.presenter.inter.IMainAPresenter;
import com.coolweather.my.view.inter.IMainAView;

public class MainAPresenterImpl implements IMainAPresenter {
    private IMainAView mIMainAView;
    private IMainAModel mIMainAModel;

    public MainAPresenterImpl(IMainAView aIMainAView) {
        mIMainAView = aIMainAView;
        mIMainAModel = new MainAModelImpl();
    }
}
