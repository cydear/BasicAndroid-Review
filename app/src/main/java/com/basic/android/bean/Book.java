package com.basic.android.bean;

import java.io.Serializable;

/**
 * [类功能说明]
 *
 * @author lary.huang
 * @version v 1.4.8 2019-10-16 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class Book implements Serializable {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
