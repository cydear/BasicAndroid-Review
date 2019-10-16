package com.basic.android.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.basic.android.db.DbOpenHelper;

/**
 * [类功能说明]
 *
 * @author lary.huang
 * @version v 1.4.8 2019-10-16 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class BookProvider extends ContentProvider {
    private static final String TAG = "BookProvider";
    public static final String AUTHORITY = "com.basic.android.provider.BookProvider";

    public static final Uri BOOK_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/book");
    public static final Uri USER_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/user");

    public static final int BOOK_URI_CODE = 0;
    public static final int USER_URI_CODE = 1;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(AUTHORITY, "book", BOOK_URI_CODE);
        sUriMatcher.addURI(AUTHORITY, "user", USER_URI_CODE);
    }

    private Context mContext;
    private SQLiteDatabase mSQLiteDatabase;

    @Override
    public boolean onCreate() {
        mContext = getContext();

        //初始化---仅仅为演示数据
        mSQLiteDatabase = new DbOpenHelper(mContext).getWritableDatabase();
        mSQLiteDatabase.execSQL("delete from " + DbOpenHelper.BOOK_TABLE_NAME);
        mSQLiteDatabase.execSQL("delete from " + DbOpenHelper.USER_TABLE_NAME);
        mSQLiteDatabase.execSQL("insert into book values(3,'Android');");
        mSQLiteDatabase.execSQL("insert into book values(4,'Ios')");
        mSQLiteDatabase.execSQL("insert into book values(5,'Html5')");
        mSQLiteDatabase.execSQL("insert into user values(1,'jake',1)");
        mSQLiteDatabase.execSQL("insert into user values(2,'jasmine',0)");
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        String tableName = getTableName(uri);
        if (TextUtils.isEmpty(tableName)) {
            throw new IllegalArgumentException("table is not null");
        }
        return mSQLiteDatabase.query(tableName, projection, selection, selectionArgs, null, null, sortOrder, null);
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        String tableName = getTableName(uri);
        if (TextUtils.isEmpty(tableName)) {
            throw new IllegalArgumentException("tableName is not null");
        }
        mSQLiteDatabase.insert(tableName, null, values);
        mContext.getContentResolver().notifyChange(uri, null);
        return uri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        String tableName = getTableName(uri);
        if (TextUtils.isEmpty(tableName)) {
            throw new IllegalArgumentException("tableName is not null");
        }
        int count = mSQLiteDatabase.delete(tableName, selection, selectionArgs);
        if (count > 0) {
            mContext.getContentResolver().notifyChange(uri, null);
        }
        return count;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        String tableName = getTableName(uri);
        if (TextUtils.isEmpty(tableName)) {
            throw new IllegalArgumentException("tableName is not null");
        }
        int row = mSQLiteDatabase.update(tableName, values, selection, selectionArgs);
        if (row > 0) {
            mContext.getContentResolver().notifyChange(uri, null);
        }
        return row;
    }

    private String getTableName(Uri uri) {
        String tableName = null;
        switch (sUriMatcher.match(uri)) {
            case BOOK_URI_CODE:
                tableName = DbOpenHelper.BOOK_TABLE_NAME;
                break;
            case USER_URI_CODE:
                tableName = DbOpenHelper.USER_TABLE_NAME;
                break;
            default:
                break;
        }
        return tableName;
    }
}
