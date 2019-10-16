package com.basic.android.book;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    public int id;
    public String bookName;
    private int bookCode;

    protected Book(Parcel in) {
        id = in.readInt();
        bookName = in.readString();
        bookCode = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(bookName);
        dest.writeInt(bookCode);
    }
}
