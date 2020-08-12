package com.example.myparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {
    int number;
    String message;

    public SimpleData(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public SimpleData(Parcel parcel) {
        this.number= parcel.readInt();
        this.message= parcel.readString();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.number);
        parcel.writeString(this.message);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){

        @Override
        public SimpleData createFromParcel(Parcel parcel) {
            return new SimpleData(parcel);
        }

        @Override
        public SimpleData[] newArray(int i) {
            return new SimpleData[i];
        }
    };
}
