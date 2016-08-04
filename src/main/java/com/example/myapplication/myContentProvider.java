package com.example.myapplication;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2016/8/3.
 */
public class myContentProvider extends ContentProvider {

    //在contentprovider被创建后调用
    @Override
    public boolean onCreate() {
        return false;
    }

    //根据uri查询select指定的条件所匹配的全部数据，并且还可以指定查询那些列，以什么方式进行排序
    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    //返回当前uri的MIME类型，如果该uri对应的数据可能包括多条数据，那么MIME类型字符串就是以vnd.android.dir/
    //开头如果该uri对应的数据只有一条记录，那么该MIME类型字符串就是以vnd.android.cursor.item/开头
    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    //根据uri插入values对应的数据
    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    //根据uri删除select指定的条件所匹配的全部数据
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    //根据uri修改select指定的条件所匹配的全部数据
    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
