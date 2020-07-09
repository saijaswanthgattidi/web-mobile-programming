// Java file for Main Log In page
// Importing all the neccesary packages
package com.example.mobileicp1;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    // Initializing variables
    Button Login;
    EditText mail;
    EditText password;
    TextView incorrect;
    String username;
    String pwd;
    boolean a = false;
    //Function to acquire login credentials and comparing with the given credentials
    //if matched then it redirects to welcome page else it displays incorrect password
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail = findViewById(R.id.mailid);
        password = findViewById(R.id.password);
        incorrect = findViewById(R.id.incorrect);
        username = mail.getText().toString();
        pwd = password.getText().toString();
        Login = findViewById(R.id.login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mail.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {
                    if (mail.getText().toString().equals("sai@gmail.com") && password.getText().toString().equals("sai123"))
                    { a = true; }
                }
                if (!a)
                { incorrect.setText("Incorrect Username or Password"); }
                else
                { reDirectToLoginpage(); }
            }
        });
    }
    public void reDirectToLoginpage () {
        Intent intent = new Intent(MainActivity.this, LoginPage.class);
        startActivity(intent);
    }
}