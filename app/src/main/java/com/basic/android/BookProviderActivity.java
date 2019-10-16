package com.basic.android;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.basic.android.bean.Book;
import com.basic.android.bean.UserModel;

/**
 * [类功能说明]
 *
 * @author lary.huang
 * @version v 1.4.8 2019-10-16 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class BookProviderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_book_provider);

        Uri bookUri = Uri.parse("content://com.basic.android.provider.BookProvider/book");

        ContentValues values = new ContentValues();
        values.put("_id", "6");
        values.put("name", "程序设计的艺术");
        getContentResolver().insert(bookUri, values);

        Cursor cursor = getContentResolver().query(bookUri, new String[]{"_id", "name"}, null, null, null);
        while (cursor.moveToNext()) {
            Book book = new Book();
            book.setId(cursor.getInt(0));
            book.setName(cursor.getString(1));
        }
        cursor.close();

        Uri userUri = Uri.parse("content://com.basic.android.provider.BookProvider/book");

        Cursor userCursor = getContentResolver().query(userUri, new String[]{"_id", "name", "sex"}, null, null, null);

        while (userCursor.moveToNext()) {
            UserModel user = new UserModel();
            user.setId(userCursor.getInt(0));
            user.setUserName(userCursor.getString(1));
            user.setMale(userCursor.getInt(2) == 1);
        }
        userCursor.close();
    }
}
