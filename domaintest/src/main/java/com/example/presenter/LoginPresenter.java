package com.example.presenter;

import com.example.interactor.LoginInteractor;
import com.example.presenter.listener.RequestLoginInterface;
import com.example.presenter.viewinterfaces.LoginViewInterface;

/**
 * Author: Oscar Alvarez
 * Date: 04/11/2015.
 */
public class LoginPresenter extends BasePresenter<LoginViewInterface> {

    private LoginInteractor interactor;
    public LoginPresenter(LoginViewInterface viewInterface, LoginInteractor interactor) {
        super(viewInterface);
        this.interactor = interactor;
    }

    public void checkValidUser(String user, String pass) {
        interactor.doLogin(user, pass, new RequestLoginInterface() {
            @Override
            public void onSuccess() {
                getViewInterface().showSuccess();
            }

            @Override
            public void onError() {
                getViewInterface().showError();
            }
        });
    }

}
