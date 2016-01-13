package com.alvarez.oscar.testmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.data.SessionTest;
import com.example.interactor.LoginInteractor;
import com.example.presenter.LoginPresenter;
import com.example.presenter.viewinterfaces.LoginViewInterface;

public class MainActivity extends AppCompatActivity implements LoginViewInterface {

    private EditText editTextUser;
    private EditText editTextPass;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        editTextUser = (EditText)findViewById( R.id.editTextUser );
        editTextPass = (EditText)findViewById( R.id.editTextPass );
        Button button = (Button)findViewById( R.id.button );

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin(editTextUser.getText().toString(), editTextPass.getText().toString());
            }
        });
    }

    @Override
    public void doLogin(String user, String pass) {
        getPresenter().checkValidUser(user, pass);
    }

    @Override
    public void showError() {
        toast = Toast.makeText(this, "Invalid user/password", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void showSuccess() {
        toast = Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public LoginPresenter getPresenter() {
        //Dependency Injection
        return new LoginPresenter(this, new LoginInteractor(new SessionTest()));
    }
}
