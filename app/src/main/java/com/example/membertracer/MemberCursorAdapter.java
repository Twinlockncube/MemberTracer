package com.example.membertracer;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.cursoradapter.widget.CursorAdapter;

class MemberCursorAdapter extends CursorAdapter {
    public MemberCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_to_do,parent);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        //Find fields to populate
        TextView member_id = view.findViewById(R.id.member_id);
        TextView full_name = view.findViewById(R.id.full_name);
        CheckBox present = view.findViewById(R.id.present);

        //Fetching Data
        /*int member_id_val = cursor.getInt(cursor.getColumnIndexOrThrow("rowid"));
        String first_name = cursor.getString(cursor.getColumnIndexOrThrow("first_name"));
        String last_name = cursor.getString(cursor.getColumnIndexOrThrow("last_name"));*/
        int member_id_val = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        String first_name = cursor.getString(cursor.getColumnIndexOrThrow("first_name"));
        String last_name = cursor.getString(cursor.getColumnIndexOrThrow("last_name"));

        //populate fields
        member_id.setText(member_id_val);
        full_name.setText(first_name+" "+last_name);
    }
}
