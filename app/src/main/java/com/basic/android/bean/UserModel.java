package com.basic.android.bean;

import java.io.Serializable;

/**
 * [类功能说明]
 *
 * @author lary.huang
 * @version v 1.4.8 2019-10-16 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class UserModel implements Serializable {
    public int id;
    public String userName;
    public boolean isMale;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }
}
