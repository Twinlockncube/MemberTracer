package com.example.membertracer;

import java.sql.Date;

class ChurchMember {
    private String first_name;
    private String last_name;
    private String contact_number;
    private String address;
    private String date_of_birth;
    private String gender;

    public void setFirstName(String first_name){
        this.first_name = first_name;
    }

    public void setLastName(String last_name){
        this.last_name = last_name;
    }

    public void setContactNumber(String contact_number){
        this.contact_number = contact_number;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setDateOfBirth(String date_of_birth){
        this.date_of_birth = date_of_birth;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    /*getters getters                   getters*/

    public String getFirstName(){
        return this.first_name;
    }

    public String getLastName(){
        return this.last_name;
    }

    public String getContactNumber(){
        return this.contact_number;
    }

    public String getAddress(){
        return this.address;
    }

    public String getDateOfBirth(){
        return this.date_of_birth;
    }

    public String getGender(){
        return this.gender;
    }

}
