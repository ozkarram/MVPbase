package com.example.interactor;

import com.example.data.SessionTest;
import com.example.presenter.listener.RequestLoginInterface;

/**
 * Author: Oscar Alvarez
 * Date: 04/11/2015.
 */
public class LoginInteractor {

    SessionTest sessionTest;
    public LoginInteractor(SessionTest sessionTest) {
        this.sessionTest = sessionTest;
    }

    public void doLogin(String user, String pass, RequestLoginInterface listener) {
        if (sessionTest.doLogin(user, pass)) {
            listener.onSuccess();
        } else {
            listener.onError();
        }
    }
}
