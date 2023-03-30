package com.example.section5;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.example.section5.models.Contact;

public class ContactDetailsActivity extends AppCompatActivity {
    @BindView(R.id.contact_name)
    TextView contactName;
    @BindView(R.id.contact_phone)
    TextView contactPhone;
    @BindView(R.id.contact_image)
    ImageView contactImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        ButterKnife.bind(this);

//        hide title bar
        getSupportActionBar().hide();


        Contact contact = (Contact) getIntent().getSerializableExtra("contact");

        contactName.setText(contact.getName());
        contactPhone.setText(contact.getPhone());
        Glide.with(this).load(contact.getAvatarURL()).circleCrop().into(contactImage);

    }
}