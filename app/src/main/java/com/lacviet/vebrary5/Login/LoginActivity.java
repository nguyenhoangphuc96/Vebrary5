package com.lacviet.vebrary5.Login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.lacviet.vebrary5.R;

public class LoginActivity extends AppCompatActivity {
    EditText edtId,edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addControl();

        addEvent();
    }

    private void addEvent() {
    }

    private void addControl() {
        edtId = findViewById(R.id.edtID);
        edtPass = findViewById(R.id.edtPassword);
    }
}
