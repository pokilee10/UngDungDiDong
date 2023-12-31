package com.example.lab3_1;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHandler extends SQLiteOpenHelper {
    // All Static variables
// Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "contactsManager";
    // Contacts table name
    private static final String TABLE_CONTACTS = "contacts";
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    private final List<Contact> contact = new ArrayList<>();
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " +
                TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
// Create tables again
        onCreate(db);
    }

    public void addContact(Contact contact) {
        contact.add(contact);
        notifyItemInserted(contact.size() - 1);
    }

    public void updateContact(Student student) {
        int index = students.indexOf(student);
        if (index != -1) {
            students.set(index, student);
            notifyItemChanged(index);
        }
    }

    public void deleteContact(Student student) {
        int index = students.indexOf(student);
        if (index != -1) {
            students.remove(index);
            notifyItemRemoved(index);
        }
    }

    public List<Contact> getAllContacts() {

    }
}
