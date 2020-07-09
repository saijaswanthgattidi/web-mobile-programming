// Java File for Welcome Page
//Importing the neccessary packages
package com.example.mobileicp1;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
//Java class consisting of a logout button which redirects to login page
public class LoginPage extends AppCompatActivity{
    Button LogoutB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        LogoutB = findViewById(R.id.logout);
        LogoutB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}