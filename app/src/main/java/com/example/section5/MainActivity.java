package com.example.section5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.section5.models.Contact;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> myWords = new ArrayList<String>();

    @BindView(R.id.words_recycler_view)
    RecyclerView wordsRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ArrayList<Contact> contacts = Contact.generateDummyContacts(10);

        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(contacts);
        wordsRecyclerView.setAdapter(myRecyclerViewAdapter);
        wordsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}