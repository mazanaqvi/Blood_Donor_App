package com.example.blood_donor_app;

public class donor {

    public  String name,location,contact,bgroup,availability;
    donor(){

    }
    public donor(String name, String bgroup, String location, String availability, String contact) {
        this.name = name;
        this.bgroup = bgroup;
        this.location = location;
        this.availability = availability;
        this.contact = contact;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBgroup(String bgroup) {
        this.bgroup = bgroup;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getBgroup() {
        return bgroup;
    }

    public String getLocation() {
        return location;
    }

    public String getAvailability() {
        return availability;
    }

    public String getContact() {
        return contact;
    }
}
