package com.example.testrealm;

import io.realm.Realm;
import io.realm.RealmResults;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Realm realm;

    RecyclerView recyclerViewContact;
    ContactAdapter contactAdapter;

    private ArrayList<Contact> contactArrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance(); // получаем экземпляр БД
        contactArrayList = new ArrayList<>(); // создаем список для RecyclerView

        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");
        saveToRealm("ilya", "1");



//        recyclerViewContact = findViewById(R.id.rvContact);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerViewContact.setLayoutManager(layoutManager);
//        recyclerViewContact.setHasFixedSize(true);

    }

    public void saveToRealm(String login, String countRepo) {
        RealmResults<Contact> contacts = realm.where(Contact.class).findAll(); // получаем всю БД по модели Contact
        try {
            realm.beginTransaction();

            Contact dataContact = new Contact();
            dataContact.setLogin(login);
            dataContact.setCountRepo(countRepo);
            realm.copyToRealm(dataContact);

            realm.commitTransaction();
        } catch (Exception e) {
            if(realm.isInTransaction()) {
                realm.cancelTransaction();
            }
            throw new RuntimeException(e);
        }
        contactArrayList.clear();
        getListContacts();
    }

    public void getListContacts() {
        RealmResults<Contact> realmResults = realm.where(Contact.class).sort("login").findAll();
        contactArrayList.addAll(realmResults);

        // помещаем наш List в адаптер для RecyclerView
        if(realmResults.size() > 0) {
//            contactAdapter.setArray(contactArrayList);
            recyclerViewContact = findViewById(R.id.rvContact);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerViewContact.setLayoutManager(layoutManager);
            recyclerViewContact.setHasFixedSize(true);
            contactAdapter = new ContactAdapter(this, contactArrayList);
            System.out.println("ContactAdapter - " + contactAdapter + "contactArrayList - " + contactArrayList.get(0).getLogin());
            recyclerViewContact.setAdapter(contactAdapter);
        }
    }
}