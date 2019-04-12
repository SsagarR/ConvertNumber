package com.example.convertnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv_result;
    private EditText et_number;
    private Button bt_click;
    private Integer number;
    private String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private String[] tens = {"", "", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninty"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_number = findViewById(R.id.et_number);
        tv_result = findViewById(R.id.tv_result);
        bt_click = findViewById(R.id.bt_click);
        bt_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Integer.parseInt(et_number.getText().toString());
                if (number < 20) {
                    tv_result.setText(ones[number]);
                    Toast.makeText(MainActivity.this, ones[number], Toast.LENGTH_SHORT).show();
                } else if (number < 100) {
                    int num1 = number / 10;
                    int num2 = number % 10;
                    if (num2 == 0) {
                        tv_result.setText(tens[num1]);
                        Toast.makeText(MainActivity.this, tens[num1], Toast.LENGTH_SHORT).show();
                    } else {
                        tv_result.setText(tens[num1] + " " + ones[num2]);
                        Toast.makeText(MainActivity.this, tens[num1] + " " + ones[num2], Toast.LENGTH_SHORT).show();
                    }
                } else if (number < 1000) {
                    int num10 = number / 100;
                    int num12 = number % 100;
                    int num1 = num12 / 10;
                    int num2 = num12 % 10;
                    if (num12 == 0) {
                        tv_result.setText(ones[num10] + " Hundred " + tens[num1]);
                        Toast.makeText(MainActivity.this, ones[num10] + " Hundred " + tens[num1], Toast.LENGTH_SHORT).show();
                    } else {
                        if (num2 == 0) {
                            tv_result.setText(ones[num10] + " Hundred " + tens[num1]);
                            Toast.makeText(MainActivity.this, ones[num10] + " Hundred " + tens[num1], Toast.LENGTH_SHORT).show();
                        } else {
                            tv_result.setText(ones[num10] + " Hundred " + tens[num1] + " " + ones[num2]);
                            Toast.makeText(MainActivity.this, ones[num10] + " Hundred " + tens[num1] + " " + ones[num2], Toast.LENGTH_SHORT).show();
                        }


                    }
                }
            }
        });
    }
}