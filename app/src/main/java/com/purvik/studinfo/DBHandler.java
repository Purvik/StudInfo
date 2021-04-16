package com.purvik.studinfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "student";

    // Contacts table name
    private static final String TABLE_STUDENT_DETAIL = "studentDetails";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_ENROLL_NO = "enroll_no";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE_NO = "phone_number";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_STUDENT_DETAIL_TABLE = "CREATE TABLE " + TABLE_STUDENT_DETAIL + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_ENROLL_NO + " TEXT,"
                + KEY_NAME + " TEXT,"
                + KEY_PHONE_NO + " TEXT " + ")";

        db.execSQL(CREATE_STUDENT_DETAIL_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT_DETAIL);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new Student Information
    void addNewStudent(Student newStud) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ENROLL_NO, newStud.get_enroll_no());
        values.put(KEY_NAME, newStud.get_name());
        values.put(KEY_PHONE_NO, newStud.get_phone_number());

        // Inserting Row
        db.insert(TABLE_STUDENT_DETAIL, null, values);
        db.close(); // Closing database connection
    }


    public boolean updateStudentInfo(int updId, int updEnrolNo, String updName, String updPhoneNo) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ENROLL_NO, updEnrolNo);
        values.put(KEY_NAME, updName);
        values.put(KEY_PHONE_NO, updPhoneNo);

        return db.update(TABLE_STUDENT_DETAIL, values, KEY_ID + "=" + updId, null) > 0;
    }


    public boolean deleteStudent(int delID){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_STUDENT_DETAIL, KEY_ID + "=" + delID, null) > 0;
    }

    // Getting All Students
    public List<Student> getAllStudentList() {

        List<Student> studentList = new ArrayList<Student>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_STUDENT_DETAIL;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.set_id(Integer.parseInt(cursor.getString(0)));
                student.set_enroll_no(Integer.parseInt(cursor.getString(1)));
                student.set_name(cursor.getString(2));
                student.set_phone_number(cursor.getString(3));

                // Adding contact to list
                studentList.add(student);

            } while (cursor.moveToNext());
        }

        // return contact list
        return studentList;
    }


}
