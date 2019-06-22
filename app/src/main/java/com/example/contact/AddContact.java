package com.example.contact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.contact.data.Dbcontact;

public class AddContact extends AppCompatActivity {
    EditText name,phone;
    Button confirm;
    Dbcontact db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        db=new Dbcontact(this);

        name=findViewById(R.id.editName);
        phone=findViewById(R.id.editphone);
        confirm=findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=name.getText().toString();
                int p=Integer.parseInt(phone.getText().toString());
                Contact contact=new Contact(n,p);
                db.addContact(contact);

            }
        });
    }
}
