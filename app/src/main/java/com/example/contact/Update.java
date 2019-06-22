package com.example.contact;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.contact.data.Dbcontact;

public class Update extends AppCompatActivity {
    Dbcontact dbcontact;
    EditText n,p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        int id=getIntent().getIntExtra("id",0);
        dbcontact=new Dbcontact(this);
        Contact contact=dbcontact.getContactId(id);
        n=findViewById(R.id.nnn);
        p=findViewById(R.id.ppp);
        n.setText(contact.getName());
        p.setText(contact.getPhone()+"");



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.delet,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_delete:
                showAlert();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAlert() {
        AlertDialog.Builder alBuilder=new AlertDialog.Builder(this);
        alBuilder.setTitle("confirmation")
                .setMessage("are you sure?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       dialog.dismiss();
                    }
                });
        AlertDialog dialog=alBuilder.create();
        dialog.show();
    }


}
