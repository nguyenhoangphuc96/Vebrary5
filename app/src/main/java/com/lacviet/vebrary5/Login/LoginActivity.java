package com.lacviet.vebrary5.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lacviet.vebrary5.MainActivity;
import com.lacviet.vebrary5.MainActivityNew;
import com.lacviet.vebrary5.R;

public class LoginActivity extends AppCompatActivity {
    EditText edtId,edtPass;
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addControl();

        addEvent();
    }

    private void addEvent() {
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActivity();
            }
        });
    }

    private void startMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivityNew.class);
        startActivity(intent);
    }

    private void addControl() {
        edtId = findViewById(R.id.edtID);
        edtPass = findViewById(R.id.edtPassword);
        tvLogin = findViewById(R.id.tvLogin);
    }
}
