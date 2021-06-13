package com.example.testrealm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private ArrayList<Contact> contactArrayList;

    public ContactAdapter(Context context, ArrayList<Contact> contacts) {
        this.inflater = LayoutInflater.from(context);
        this.contactArrayList = contacts;
    }

    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
        Contact contact = contactArrayList.get(position);
        System.out.println(contact.getCountRepo());
        holder.tvLogin.setText(contact.getLogin());
        holder.tvCountRepo.setText(contact.getCountRepo());
    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        final TextView tvLogin, tvCountRepo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLogin = itemView.findViewById(R.id.tvLogin);
            tvCountRepo = itemView.findViewById(R.id.tvCountRepo);
        }
    }
}
