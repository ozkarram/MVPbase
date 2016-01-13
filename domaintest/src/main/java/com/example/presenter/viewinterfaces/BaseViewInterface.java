package com.example.presenter.viewinterfaces;

import com.example.presenter.BasePresenter;
import com.example.presenter.LoginPresenter;

/**
 * Author: Oscar Alvarez
 * Date: 04/11/2015.
 */
public interface BaseViewInterface<P extends BasePresenter> {
    P getPresenter();
}
