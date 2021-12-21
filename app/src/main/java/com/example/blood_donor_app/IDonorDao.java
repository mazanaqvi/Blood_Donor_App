package com.example.blood_donor_app;
import java.util.ArrayList;
import java.util.Hashtable;

public interface IDonorDao {

    public void save(Hashtable<String,String> attributes);
    public void save(ArrayList<Hashtable<String,String>> objects);
    public ArrayList<Hashtable<String,String>> load();
    public Hashtable<String,String> load(String id);
}


