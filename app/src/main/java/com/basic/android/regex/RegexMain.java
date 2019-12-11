package com.basic.android.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMain {
    public static void main(String[] args) {
        String[] params = {"w892348923", "您好中国34278ey@xx.com您好", "我们34553807@qq.com的未激活8237814@163.com哈哈哈"};

        //Pattern emailer = Pattern.compile("\\w+?@\\w+?.com");

        String regex = "[A-Za-z0-9]+@\\w+.\\w(.[\\w])?";
        Pattern emailer = Pattern.compile(regex);
        Matcher matcher = emailer.matcher(params[2]);
        while (matcher.find()) {
            String email = matcher.group();
            System.out.println(email);
        }
    }
}
