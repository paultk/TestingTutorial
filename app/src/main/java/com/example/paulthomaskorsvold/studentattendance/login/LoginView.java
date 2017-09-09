package com.example.paulthomaskorsvold.studentattendance.login;

/**
 * Created by paulthomaskorsvold on 9/8/17.
 */

public interface LoginView {

    void showErrorMessageForUsernameAndPassword();

    void showErrorMessageloginsMaxedOut();

    void showMessageLoginSuccess();
}
