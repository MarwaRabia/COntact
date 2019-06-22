package com.example.contact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.contact.data.Dbcontact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    Button button;
    Dbcontact dbcontact;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbcontact=new Dbcontact(this);
        list=findViewById(R.id.list);
        button=findViewById(R.id.btn);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,AddContact.class);
                startActivity(i);
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact selected=(Contact) parent.getItemAtPosition(position);

                Intent i=new Intent(MainActivity.this,Update.class);
                i.putExtra("id",selected.getId());
                startActivity(i);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Contact> arrayList=dbcontact.getAllcontact();
//        arrayList.add(new Contact("marwa",2589));
//        arrayList.add(new Contact("mariam",25259));
//        arrayList.add(new Contact("mwda",49349));
//        arrayList.add(new Contact("momhmed",3789));
//        arrayList.add(new Contact("mage",7896));
        ContactAdapter contactAdapter=new ContactAdapter(this,R.layout.item,arrayList);

        list.setAdapter(contactAdapter);
    }
}
