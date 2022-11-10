package com.example.myapplication.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Aluno implements Parcelable {
    private String id;
    private String name;
    private String Sobrenome;

    public Aluno(String id, String name) {
        this.id = id;
        this.name = name;
    }

    protected Aluno(Parcel in) {
        id = in.readString();
        name = in.readString();
    }

    public static final Creator<Aluno> CREATOR = new Creator<Aluno>() {
        @Override
        public Aluno createFromParcel(Parcel in) {
            return new Aluno(in);
        }

        @Override
        public Aluno[] newArray(int size) {
            return new Aluno[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
    }
}
