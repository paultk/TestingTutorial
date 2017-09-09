package com.example.paulthomaskorsvold.studentattendance.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.paulthomaskorsvold.studentattendance.R;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText editUsername;
    private EditText editPassword;
    private Button loginButton;
    private LoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void showErrorMessageForUsernameAndPassword() {

    }

    @Override
    public void showErrorMessageloginsMaxedOut() {

    }

    @Override
    public void showMessageLoginSuccess() {

    }

    private void initializePresenter() {
        loginPresenter = new LoginPresenter(this);
    }

    private void initializeViews() {
        editUsername = (EditText) findViewById(R.id.editUsername);
        editPassword = (EditText) findViewById(R.id.editPassword1);
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.attemptLogin(editUsername.getText().toString().trim(), editPassword.getText().toString().trim());
            }
        });
    }
}
