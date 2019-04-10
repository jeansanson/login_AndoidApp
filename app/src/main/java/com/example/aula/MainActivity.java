package com.example.aula;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText login = findViewById(R.id.login);
        final EditText passsword = findViewById(R.id.password);
        final Button enter = findViewById(R.id.enter);
        final TextView loginResult = findViewById(R.id.result);

        loginResult.setText("");

        View.OnClickListener loginEnter = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence loginText = login.getText().toString();
                String passwordText = passsword.getText().toString();


                if(isValidEmail(loginText) && passwordText.length()>0){
                    loginResult.setText("Login válido");
                }else {
                    loginResult.setText("Login inválido");
                }
            }
        };
        enter.setOnClickListener(loginEnter);
    }

    public static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
}
