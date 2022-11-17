package com.example.assignment_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmployeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        EditText et1 = (EditText) findViewById(R.id.empId);
        EditText et2 = (EditText) findViewById(R.id.empName);
        EditText et3 = (EditText) findViewById(R.id.empTitle);
        EditText et4 = (EditText) findViewById(R.id.empPhone);
        EditText et5 = (EditText) findViewById(R.id.empmail);
        EditText et6 = (EditText) findViewById(R.id.empDept);


        Emp_DB newEmp =new Emp_DB(this);
        Button empButton =(Button)findViewById(R.id.empBtn) ;
        empButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Id = Integer.parseInt(et1.getText().toString());
                String name = et2.getText().toString();
                String title = et3.getText().toString();
                String phone = et4.getText().toString();
                String mail = et5.getText().toString();
                int empDept = Integer.parseInt(et6.getText().toString());
                long resultOfAddingEmp = newEmp.CreateNewEmp(Id ,name ,title , phone, mail , empDept) ;
                if(resultOfAddingEmp!=-1)
                {
                    Toast.makeText(getApplicationContext(),"Employee Added",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Employee Not added ",Toast.LENGTH_SHORT).show();
                }

            }
        });
        Button empDataBtn =(Button)findViewById(R.id.empData);
        empDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent DataIntent =new Intent(EmployeeActivity.this,DataShow_Activity.class) ;
                startActivity(DataIntent);

            }
        });


    }
}