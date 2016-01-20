package com.example.kimjh.applicationcomponentpj;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by kimjh on 2016-01-21.
 */
public class Person implements Parcelable {

    String message;
    String name;
    int age;

    public Person(){}   //기본 생성자 생성

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(message);
        dest.writeString(name);
        dest.writeInt(age);
    }
    //Parcel에 Person의 데이터를 write한다.

    public static final Creator<Person> CREATOR = new Creator<Person>() {   //Creator정의
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }   //Parcel로 부터 객체를 생성하는 함수.

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }   //size만큼 array를 생성 해주면 된다.
    };

    protected Person(Parcel source) {
        message = source.readString();
        name = source.readString();
        age = source.readInt();
    }// 주의점 writeToParcel과 생성자의 데이테 읽어 오는 순서가 동일해야 한다.
}
