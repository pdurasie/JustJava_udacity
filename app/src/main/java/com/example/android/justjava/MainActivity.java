/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        int quantity = 1;

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox creamCheckbox = (CheckBox) findViewById(R.id.cream_checkbox);
        boolean creamChecked = creamCheckbox.isChecked();
        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean chocolateChecked = chocolateCheckbox.isChecked();

        int price = calculatePrice();
        String summary = createOrderSummary(price, creamChecked, chocolateChecked);
        displayMessage(summary);
    }

    public int calculatePrice(){
        int price = quantity * 5;
        return price;
    }

    public void increment(View view) {
            quantity++;
            displayQuantity(quantity);
        }

     public void decrement(View view) {
            quantity--;
            displayQuantity(quantity);
        }

        public String createOrderSummary(int totalPrice, boolean creamChecked, boolean chocolateChecked){
            String name = "Sigbert Schnösel";
            String summary = "Name: " + name +
                    "\nAdd whipped cream? " + creamChecked +
                    "\nAdd chocolate? " + chocolateChecked +
                    "\nQuantity: " + quantity +
                    "\nTotal: " + totalPrice +
                    "\nThank you!";
            return summary;
        }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}