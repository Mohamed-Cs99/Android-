package com.example.assignment_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        EditText et1 =(EditText)findViewById(R.id.deptId);
        EditText et2 =(EditText)findViewById(R.id.deptName);
        Button  deptBtn =(Button)findViewById(R.id.deptBtn);
        Button employeeActivity =(Button)findViewById(R.id.EmpActiv) ;
        final  Emp_DB newDept =new Emp_DB(this);
         deptBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 int id = Integer.parseInt(et1.getText().toString()) ;
                 String dName =et2.getText().toString() ;
                 long res = newDept.CreateNewDept(id , dName) ;
                 if(res!=-1)
                 {
                     Toast.makeText(getApplicationContext(),"Department added ",Toast.LENGTH_LONG).show();
                 }
                 else
                 {
                     Toast.makeText(getApplicationContext(),"Department Not Added ",Toast.LENGTH_LONG).show();
                 }
             }
         });
        employeeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this ,EmployeeActivity.class);
                startActivity(it);

            }
        });

    }
}