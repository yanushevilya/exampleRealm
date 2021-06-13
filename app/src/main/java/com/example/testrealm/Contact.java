package com.example.testrealm;

import io.realm.RealmObject;

public class Contact extends RealmObject {
    String login;
    String countRepo;

    public String getLogin() {
        return login;
    }

    public String getCountRepo() {
        return countRepo;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setCountRepo(String countRepo) {
        this.countRepo = countRepo;
    }
}
