package com.example.myapplication;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.util.Log;
import android.provider.ContactsContract.CommonDataKinds;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver cr = getContentResolver();
        //ContactsContract.Contacts.CONTENT_URI表示我们要查询的联系人的地址
        //查出联系人id
        Cursor c = cr.query(Contacts.CONTENT_URI, new String[]{ContactsContract.Contacts._ID, Contacts.DISPLAY_NAME}, null, null, null, null);
        if (c != null) {
            while (c.moveToNext()) {
                int id = c.getInt(c.getColumnIndex("_id"));
                String name = c.getString(c.getColumnIndex("display_name"));
                Log.i("ln", "这是id" + id);
                Log.i("ln", "这是name" + name);
                //根据联系人id查出电话号码
                Cursor c1 = cr.query(CommonDataKinds.Phone.CONTENT_URI, new String[]{CommonDataKinds.Phone.NUMBER, CommonDataKinds.Phone.TYPE}, CommonDataKinds.Phone.CONTACT_ID + "=" + id, null, null);
                if (c1 != null) {
                    while (c.moveToNext()) {
                        int type = c1.getInt(c1.getColumnIndex(CommonDataKinds.Phone.TYPE));
                        if (type == CommonDataKinds.Phone.TYPE_HOME) {
                            Log.i("ln", "家庭电话" + c1.getString(c1.getColumnIndex(CommonDataKinds.Phone.NUMBER)));
                        } else if (type == CommonDataKinds.Phone.TYPE_MOBILE) {
                            Log.i("ln", "移动电话" + c1.getString(c1.getColumnIndex(CommonDataKinds.Phone.NUMBER)));
                        }
                    }
                    c1.close();
                }
                //根据联系人的id查出联系人的邮箱地址
                Cursor c2 = cr.query(CommonDataKinds.Email.CONTENT_URI, new String[]{CommonDataKinds.Email.DATA, CommonDataKinds.Email.TYPE}, CommonDataKinds.Email.CONTACT_ID + "=" + id, null, null);
                if (c2!=null)
                {
                    while (c2.moveToNext())
                    {
                        int type=c2.getInt(c2.getColumnIndex(CommonDataKinds.Email.TYPE));
                    }
                }
            }
        }
    }
}
