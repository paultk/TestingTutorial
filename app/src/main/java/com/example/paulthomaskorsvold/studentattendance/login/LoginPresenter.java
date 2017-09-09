package com.example.paulthomaskorsvold.studentattendance.login;

/**
 * Created by paulthomaskorsvold on 9/8/17.
 */

public class LoginPresenter {

    private final LoginView LOGIN_VIEW;

    public LoginPresenter(LoginView loginView) {
        this.LOGIN_VIEW = loginView;
    }



    private static final int MAX_LOGIN_ATTEMPTS = 3;
    private int loginAttempts;

    public boolean isLoginAttemptsExceeded() {
        return (loginAttempts >= MAX_LOGIN_ATTEMPTS);
    }

    public int incrementAttempts() {
        return ++loginAttempts;
    }


    public boolean attemptLogin(String username, String password) {
        if(isLoginAttemptsExceeded()) {
            LOGIN_VIEW.showErrorMessageloginsMaxedOut();
            return false;
        }
        if(username.equals("testUsername") && password.equals("testPassword")) {
            LOGIN_VIEW.showMessageLoginSuccess();
            return true;
        }

        incrementAttempts();
        LOGIN_VIEW.showErrorMessageForUsernameAndPassword();
        return false;
    }
}
