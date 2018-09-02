package com.example.jimenez.appmunitacna.objects;

import com.google.firebase.auth.FirebaseUser;

public class Global {
    public Global() {
    }

    public static FirebaseUser getGlobalNameUser() {
        return GlobalNameUser;
    }

    public static void setGlobalNameUser(FirebaseUser globalNameUser) {
        GlobalNameUser = globalNameUser;
    }

    public static FirebaseUser GlobalNameUser;
}
