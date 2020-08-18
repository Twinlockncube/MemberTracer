package com.example.membertracer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static com.example.membertracer.MemberDetailsFragment.*;

public class MemberDetails extends AppCompatActivity {
    ImageView btn_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn_save = findViewById(R.id.btn_save);

       btn_save.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String reg_date_val = reg_date.getText().toString();
               String first_name_val = first_name.getText().toString();
               String last_name_val = last_name.getText().toString();
               String contact_number_val = contact_number.getText().toString();
               String address_val = address.getText().toString();
               String gender_val = findViewById(gender.getCheckedRadioButtonId()).getTag().toString();

               ChurchMember member = new ChurchMember();
               member.setDateOfBirth(reg_date_val);
               member.setFirstName(first_name_val);
               member.setLastName(last_name_val);
               member.setContactNumber(contact_number_val);
               member.setAddress(address_val);
               member.setGender(gender_val);
           }
       });

    }

}
