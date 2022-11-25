package com.example.assignment_4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Emp_DB extends SQLiteOpenHelper {

    private static String databaseName = "EmployeeData";
    SQLiteDatabase sql_db;

    public Emp_DB(Context context) {
        super(context, databaseName, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table department(dept_id integer primary key autoIncrement, name text )");

        db.execSQL("Create table employee(Emp_id integer primary key autoincrement ,name text not null , title text ,phone text not null ,email text not null ,dept_id integer , foreign key(dept_id)references department(dept_id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists department");
        db.execSQL("drop table if exists employee");
        onCreate(db);

    }

        public long CreateNewDept(int id, String name) {
        ContentValues cv = new ContentValues();
        cv.put("dept_id", id);
        cv.put("name", name);
        sql_db = getWritableDatabase();
        long DeptInsertResult = sql_db.insert("department", null, cv);
        sql_db.close();
        return DeptInsertResult;
    }

    public long CreateNewEmp(int id, String name, String title, String phone, String email, int depId) {
        ContentValues cv = new ContentValues();
        cv.put("Emp_id", id);
        cv.put("name", name);
        cv.put("title", title);
        cv.put("phone", phone);
        cv.put("email", email);
        cv.put("dept_id", depId);
        sql_db = getWritableDatabase();
        long EmpInsertResult = sql_db.insert("employee", null, cv);
        sql_db.close();
        return EmpInsertResult;
    }

    public Cursor FetchEmployees() {
        sql_db = getReadableDatabase();
        String[] EmployeeDetails = {"Emp_id", "name", "title", "phone", "email", "dept_id"};
        Cursor cr = sql_db.query("employee", EmployeeDetails, null, null, null, null, null);
        if (cr != null)
            cr.moveToFirst();
        sql_db.close();
        return cr;
    }

    public Cursor getEmployees(String n)
    {
        sql_db =getReadableDatabase() ;
        String []args ={'%'+n+'%'} ;
        Cursor cr = sql_db.rawQuery("select name from employee where name like ?",args) ;
        if (cr != null)
            cr.moveToFirst();
        sql_db.close();
        return cr;
    }

}
