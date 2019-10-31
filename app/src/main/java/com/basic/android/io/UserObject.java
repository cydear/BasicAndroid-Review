package com.basic.android.io;

import java.io.Serializable;

/**
 * [类功能说明]
 *
 * @author lary.huang
 * @version v 1.4.8 2019-10-31 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class UserObject implements Serializable {
    private static final long serialVersionUID = 1933883663599083196L;

    private String userName;

    private String nickName;

    private int age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserObject{" +
                "userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                '}';
    }
}
