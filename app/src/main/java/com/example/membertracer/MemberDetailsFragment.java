package com.example.membertracer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MemberDetailsFragment extends Fragment {
    public static EditText reg_date =null;
    public static EditText first_name =null;
    public static EditText last_name =null;
    public static EditText contact_number =null;
    public static EditText address =null;
    public static RadioGroup gender =null;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first2, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*-----------------Initialising church member properties-----------------------*/
        reg_date = view.findViewById(R.id.registration_date);
        first_name = view.findViewById(R.id.first_name);
        last_name = view.findViewById(R.id.last_name);
        contact_number = view.findViewById(R.id.contact_number);
        address = view.findViewById(R.id.address);
        gender = view.findViewById(R.id.gender);
        /*----------------------------------------------------------------------------*/
        reg_date.setText(getCurrentDate());

    }

    //get current date
    private String getCurrentDate(){
        String DATE_FORMAT = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date the_date = Calendar.getInstance().getTime();
        String today_date = dateFormat.format(the_date);
        return today_date;
    }
}
