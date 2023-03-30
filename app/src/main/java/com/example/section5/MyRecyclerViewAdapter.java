package com.example.section5;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.example.section5.models.Contact;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.RecyclerViewHolder> {


    private ArrayList<Contact> contacts;

    public MyRecyclerViewAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }


    @NonNull
    @NotNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_card, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.contactName.setText(contact.getName());
        holder.contactPhone.setText(contact.getPhone());
        Glide.with(holder.contactImage.getContext()).load(contact.getAvatarURL()).circleCrop().into(holder.contactImage);
        Intent intent = new Intent(holder.itemView.getContext(), ContactDetailsActivity.class);
        intent.putExtra("contact", contact);
        holder.itemView.setOnClickListener(v -> {
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.contact_name)
        TextView contactName;

        @BindView(R.id.contact_phone)
        TextView contactPhone;

        @BindView(R.id.contact_image)
        ImageView contactImage;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }


}
