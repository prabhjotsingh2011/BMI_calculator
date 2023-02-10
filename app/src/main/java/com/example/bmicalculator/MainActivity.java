package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        variable diclaration for storing the references of the views
        TextView txtResult;
        Button btnCalculate;
        EditText edtWeight,edtHeight,edtHeightIn;
        LinearLayout llMain;

//        storing the reference of the views
        txtResult  = findViewById(R.id.txtResult);
        btnCalculate = findViewById(R.id.btnCalculate);
        edtWeight = findViewById(R.id.edtweight);
        edtHeight  = findViewById(R.id.edtHeight);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        llMain = findViewById(R.id.llMain);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeight.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());

                int totalI = ft*12 + in;
                double totalCm = totalI *2.530;
                double totalM = totalCm/100;

                double bmi = wt/(totalM*totalM);

                if(bmi >25){
                    txtResult.setText("you are over weight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorover));
                }
                 else if(bmi<18) {
                    txtResult.setText("you are under weight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorunder));
                }
                else {
                    txtResult.setText("you are healthy ");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorhealthy));
                }
            }
        });



    }
}