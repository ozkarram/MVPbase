package com.example.presenter.viewinterfaces;

/**
 * Author: Oscar Alvarez
 * Date: 04/11/2015.
 */
public interface LoginViewInterface extends BaseViewInterface {

    void doLogin(String user, String pass);

    void showError();

    void showSuccess();

}
