package com.example.contact;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {
    Context context;
    int res;

    public ContactAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
        this.context=context;
        res=resource;
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(res,parent,false);
        TextView name=convertView.findViewById(R.id.name);
        TextView phone=convertView.findViewById(R.id.phone);
        Contact curntContact=getItem(position);
        name.setText(curntContact.getName());
        phone.setText(String.valueOf(curntContact.getPhone()));

        return convertView;
    }
}

