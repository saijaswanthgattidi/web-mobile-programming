package com.example.mobileicp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Html;

import com.example.mobileicp2.MenuPage;

// Create Order Summary
public class SumPage extends AppCompatActivity {

    TextView summaryText;
    Button OrderButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum_page);
        summaryText = findViewById(R.id.summaryText);
        summaryText.setText(Html.fromHtml("<u>Order Summary</u><br/><br/>"));
        if (getIntent() != null) {
            summaryText.append(getIntent().getStringExtra("orderSummary"));
        } else {
            summaryText.setText("No recent orders !!");
        }
        summaryText.append(Html.fromHtml("<br/>"));
        summaryText.setVisibility(View.VISIBLE);
        OrderButton = findViewById(R.id.orderinsummary);

        OrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reDirectToOrderingPage();
            }
        });
    }
    public void reDirectToOrderPage() {
        Intent intent = new Intent(SumPage.this, MenuPage.class);
        startActivity(intent);
    }

}
