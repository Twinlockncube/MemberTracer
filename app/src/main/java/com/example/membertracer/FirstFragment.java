package com.example.membertracer;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {
    public static ListView listView = null;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Creating the ListView
       // String[] members = {"Twinlock Ncube","Winnie Moombe","Akhumzi Ncube","Steven Ndlovu","Paul Baker","Linonel Messi","Nelson Ndlovu","John Barnes","Mitchel Obama","Akhumzi Ncube","Steven Ndlovu","Paul Baker","Linonel Messi","Nelson Ndlovu"};
        listView = view.findViewById(R.id.list_item);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_multiple_choice,android.R.id.text1,members);
        //listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        String DATABASE_NAME = "ChurchMembers.db";
        DatabaseHelper helper = new DatabaseHelper(getContext(),DATABASE_NAME,null,1);
        Cursor cursor = helper.getAllData();
        MemberCursorAdapter adapter = new MemberCursorAdapter(getContext(),cursor,0);
        listView.setAdapter(adapter);
    }

}
