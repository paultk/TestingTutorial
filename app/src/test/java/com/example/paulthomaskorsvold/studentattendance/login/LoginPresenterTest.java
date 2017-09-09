package com.example.paulthomaskorsvold.studentattendance.login;

import junit.framework.Assert;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by paulthomaskorsvold on 9/8/17.
 */
public class LoginPresenterTest {

    @Test
    public void checkIfLoginAttemptsExceeded(){

        LoginView loginView = mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);

        Assert.assertEquals(1, loginPresenter.incrementAttempts());
        Assert.assertEquals(2, loginPresenter.incrementAttempts());
        Assert.assertEquals(3, loginPresenter.incrementAttempts());
        Assert.assertTrue(loginPresenter.isLoginAttemptsExceeded());
    }

    @Test
    public void checkUsernameAndPasswordIsCorrect() {

        LoginView loginView = mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);

        Assert.assertTrue(loginPresenter.attemptLogin("testUsername", "testPassword"));
        verify(loginView).showMessageLoginSuccess();

    }

    @Test
    public void checkUsernameAndPasswordIsIncorrect() {

        LoginView loginView = mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);

        Assert.assertFalse(loginPresenter.attemptLogin("xyz", "abc"));
        verify(loginView).showErrorMessageForUsernameAndPassword();

    }

    @Test
    public void checkIfLoginAttemptsIsExceededAndViewMethodCalled() {
        LoginView loginView = mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);

        loginPresenter.attemptLogin("dd", "ss");
        loginPresenter.attemptLogin("dd", "ss");
        loginPresenter.attemptLogin("dd", "ss");
        loginPresenter.attemptLogin("dd", "ss");

        verify(loginView).showErrorMessageloginsMaxedOut();
    }

}