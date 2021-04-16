package com.purvik.studinfo;

/**
 * Purvik Rana - Student Main Class
 * Attributes: id, enroll_no, name, phone_number;
 * Constructor: empty, all parameter, three parameter
 * Getter & Setters: all attributes
 */
public class Student {

    //Private Variable
    int _id;
    int _enroll_no;
    String _name;
    String _phone_number;

    //empty constructor
    public Student() {
    }

    //all parameter in Constructor
    public Student(int _id, String _name, int _enroll_no, String _phone_number) {
        this._id = _id;
        this._name = _name;
        this._enroll_no = _enroll_no;
        this._phone_number = _phone_number;
    }

    //three parameter Constructor
    public Student(int _enroll_no, String _name, String _phone_number) {
        this._enroll_no = _enroll_no;
        this._name = _name;
        this._phone_number = _phone_number;
    }


    //Getters for  all fields


    public int get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public int get_enroll_no() {
        return _enroll_no;
    }

    public String get_phone_number() {
        return _phone_number;
    }

    //Setters for all fields
    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_enroll_no(int _enroll_no) {
        this._enroll_no = _enroll_no;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_phone_number(String _phone_number) {
        this._phone_number = _phone_number;
    }
}
