package com.example.currency_convertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button convert_btn =(Button)findViewById(R.id.btn1) ;
        Button clear_btn = (Button)findViewById(R.id.btn2);

        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Finput =(EditText)findViewById(R.id.inputONe);
                EditText Sinput =(EditText)findViewById(R.id.inputTwo);
                Finput.setText("");
                Sinput.setText("");
            }
        });

        convert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MoneyConverter obj =new MoneyConverter();

                EditText Finput =(EditText)findViewById(R.id.inputONe);
                EditText Sinput =(EditText)findViewById(R.id.inputTwo);

                if(!(Finput.getText().toString().equals("")))
                {
                    float money =Float.parseFloat(Finput.getText().toString());
                    obj.setM(money);
                    money=obj.convert_to_Egyptian();
                    Sinput.setText(String.valueOf(money));
                }
                else if (!(Sinput.getText().toString().equals("")))
                {
                    float money =Float.parseFloat(Sinput.getText().toString());
                    obj.setM(money);
                    money=obj.convert_to_dollar();
                    Finput.setText(String.valueOf(money));
                }

                else {
                    Toast.makeText(getApplicationContext(),"Please Entere a Valid data",Toast.LENGTH_LONG).show();
                }

            }
        });



    }
}