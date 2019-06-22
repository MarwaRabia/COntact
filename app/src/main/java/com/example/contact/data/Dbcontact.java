package com.example.contact.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.contact.Contact;

import java.util.ArrayList;

public class Dbcontact  extends SQLiteOpenHelper {
    private static final String DB_Name="myphone.db";
    private static final int DB_VERTION=1;
    private static final String KEY_ID="id";
    private static final String KEy_NAME="name";
    private static final String KEY_PHONE="phone";
    private static final String TABLE_CONTACT="telephone";

    public Dbcontact( Context context) {
        super(context, DB_Name, null, DB_VERTION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String  create=" CREATE TABLE "+TABLE_CONTACT+" ( " +  KEY_ID +" INTEGER  primary key , "+

                KEy_NAME+" varchar (30) ," +KEY_PHONE+" integer );";

        db.execSQL(create);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String delete="Drop TABLE "+TABLE_CONTACT;
        db.execSQL(delete);
        onCreate(db);

    }
  public void addContact(Contact contact){
        SQLiteDatabase db=this.getWritableDatabase();

      ContentValues values=new ContentValues();

      values.put(KEy_NAME,contact.getName());
      values.put(KEY_PHONE,contact.getPhone());

        db.insert(TABLE_CONTACT,null,values);
  }
  public ArrayList<Contact>getAllcontact(){
      ArrayList<Contact>arrayList=new ArrayList<>();

      String select="select*FROM "+TABLE_CONTACT+";";

      SQLiteDatabase db=this.getReadableDatabase();


      Cursor cursor=db.rawQuery(select,null);
      if( cursor!=null&&cursor.moveToFirst()){

          do{
              int id=cursor.getInt(cursor.getColumnIndex(KEY_ID));
              String name=cursor.getString(cursor.getColumnIndex(KEy_NAME));
              int phone=cursor.getInt(cursor.getColumnIndex(KEY_PHONE));


              Contact contact=new Contact(id,name,phone);
              arrayList.add(contact);
          }
          while (cursor.moveToNext());


      }
      return arrayList;



  }
  public Contact getContactId(int id){
        SQLiteDatabase database=this.getReadableDatabase();
        String select="select *from "+TABLE_CONTACT+" where  id = "+id ;
        Cursor cursor=database.rawQuery(select,null);
        Contact contact=null;
        if (cursor.moveToNext()){

                String name=cursor.getString(cursor.getColumnIndex(KEy_NAME));
                int conactId=cursor.getInt(cursor.getColumnIndex(KEY_ID));
            int phone=cursor.getInt(cursor.getColumnIndex(KEY_PHONE));
            contact=new Contact(id,name,phone);

cursor.close();

        }
        return contact;


  }
}
