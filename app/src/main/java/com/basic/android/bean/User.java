package com.basic.android.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * [类功能说明]
 *
 * @author lary.huang
 * @version v 1.4.8 2019-10-15 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class User implements Parcelable {
    public int id;
    public String userName;
    public boolean isMale;

    protected User(Parcel in) {
        id = in.readInt();
        userName = in.readString();
        isMale = in.readByte() != 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(userName);
        dest.writeByte((byte) (isMale ? 1 : 0));
    }
}
