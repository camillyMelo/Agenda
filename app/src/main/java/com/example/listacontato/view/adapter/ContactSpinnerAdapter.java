package com.example.listacontato.view.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

import model.Contact;

public class ContactSpinnerAdapter extends ArrayAdapter<Contact> {

    private List<Contact> listContact;
    public ContactSpinnerAdapter(@NonNull Context context, int resource, @NonNull List<Contact> values) {
        super(context, resource, values);
    }
}
