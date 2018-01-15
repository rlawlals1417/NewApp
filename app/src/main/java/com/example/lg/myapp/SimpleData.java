package com.example.lg.myapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by LG on 2018-01-15.
 */

public class SimpleData implements Parcelable {

    int number;
    String message;

    public SimpleData(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public SimpleData(Parcel src){      //Parcel에서 SimpleData 변수를 read 로 복원
        number = src.readInt();
        message = src.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public SimpleData createFromParcel(Parcel src){
            return new SimpleData(src);
        }

        public SimpleData[] newArray(int size){
            return new SimpleData[size];

        }
    };
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {  //SimpleData를 Parcel 로 바꿈
        dest.writeInt(number);
        dest.writeString(message);
    }
}
