package com.example.mobileicp2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.lang3.BooleanUtils;

import androidx.appcompat.app.AppCompatActivity;

public class MenuPage extends AppCompatActivity {
    private static final Integer base_rate = 20;
    private static final Integer mushroom_price = 5;
    private static final Integer spinach_price = 8;
    private static final Integer chicken_price = 10;
    private static final Integer bacon_price = 15;
    float total_price;
    Integer quantity = 1;
    String orderSummary;

    EditText customer_name;
    TextView selected_quantity;
    CheckBox mushroom, spinach, chicken, bacon;
    RadioButton cokedrink, pepsidrink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);

        selected_quantity = findViewById(R.id.quantity_text_view);
        customer_name = findViewById(R.id.name);
        mushroom = findViewById(R.id.mushroom_check);
        spinach = findViewById(R.id.spinach_check);
        chicken = findViewById(R.id.chicken_check);
        bacon = findViewById(R.id.bacon_check);
        cokedrink = findViewById(R.id.coke_drink);
        pepsidrink = findViewById(R.id.pepsi_drink);
    }

    private boolean isUserEmpty() {
        String userName = customer_name.getText().toString();
        if (userName == null || userName.isEmpty()) {
            Context context = getApplicationContext();
            String upperLimitToast = "Customer Name is Required";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, upperLimitToast, duration);
            toast.show();
            return true;
        }
        return false;
    }

    private String fetchDetails() {
        boolean mushroom_flag = mushroom.isChecked();
        boolean spinach_flag = spinach.isChecked();
        boolean chicken_flag = chicken.isChecked();
        boolean bacon_flag = bacon.isChecked();
        boolean coke_flag = cokedrink.isChecked();
        boolean pepsi_flag = pepsidrink.isChecked();

        total_price = calculate_price(mushroom_flag, spinach_flag, chicken_flag, bacon_flag, quantity);

        return fetchOrderSummary(customer_name.getText().toString(), mushroom_flag, spinach_flag, chicken_flag, bacon_flag,coke_flag,pepsi_flag, total_price);
    }

    public void orderSummary(View view) {
        if (!isUserEmpty()) {
            orderSummary = fetchDetails();
            Intent intent = new Intent(MenuPage.this, SumPage.class);
            intent.putExtra("orderSummary", orderSummary);
            startActivity(intent);
        }
    }

    public void orderPizzaMain(View view) {
        if (!isUserEmpty()) {
            orderSummary = fetchDetails();
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"customer@gmail.com"});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Order Summary");
            emailIntent.putExtra(Intent.EXTRA_TEXT, orderSummary);
            startActivity(Intent.createChooser(emailIntent, ""));
        }
    }
    private String fetchOrderSummary(String userName, boolean mushroom_flag, boolean spinach_flag,
                                     boolean chicken_flag, boolean bacon_flag,boolean coke_flag,boolean pepsi_flag, float total_price) {
        return getString(R.string.order_summary_name,userName) +"\n"+
                getString(R.string.order_summary_coke,BooleanUtils.toStringYesNo(coke_flag)) +"\n"+
                getString(R.string.order_summary_pepsi,BooleanUtils.toStringYesNo(pepsi_flag)) +"\n"+
                getString(R.string.order_summary_mushroom, BooleanUtils.toStringYesNo(mushroom_flag))+"\n"+
                getString(R.string.order_summary_spinach,BooleanUtils.toStringYesNo(spinach_flag)) +"\n"+
                getString(R.string.order_summary_chicken,BooleanUtils.toStringYesNo(chicken_flag)) +"\n"+
                getString(R.string.order_summary_bacon,BooleanUtils.toStringYesNo(bacon_flag)) +"\n"+
                getString(R.string.order_summary_quantity,quantity)+"\n"+
                getString(R.string.order_summary_total_price,total_price) +"\n"+
                getString(R.string.thank_you);
    }

    private float calculate_price(boolean mushroom, boolean spinach, boolean chicken, boolean bacon, Integer quantity) {
        int basePrice = base_rate;
        if (mushroom) {
            basePrice += mushroom_price;
        }
        if (spinach) {
            basePrice += spinach_price;
        }
        if (chicken){
            basePrice += chicken_price;
        }
        if(bacon){
            basePrice += bacon_price;
        }
        return quantity * basePrice;
    }

    public void more(View view) {
        if (quantity < 10) {
            quantity = quantity + 1;
            display(quantity);
        } else {
            Log.i("PizzaOrder", "Please select less than 10 Pizzas");
            Context context = getApplicationContext();
            String lowerLimitToast = "Please select less than 10 Pizzas";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, lowerLimitToast, duration);
            toast.show();
            return;
        }
    }


    public void less(View view) {
        if (quantity > 1) {
            quantity = quantity - 1;
            display(quantity);
        } else {
            Log.i("CoffeOrder", "Please select atleast one Pizza");
            Context context = getApplicationContext();
            String upperLimitToast = "Please select atleast one Pizza";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, upperLimitToast, duration);
            toast.show();
            return;
        }
    }

    private void display(int number) {
        selected_quantity.setText("" + number);
    }

}