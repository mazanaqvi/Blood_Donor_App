package com.example.blood_donor_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class donor_adapter extends RecyclerView.Adapter<donor_adapter.ViewHolder> implements Filterable {
    public static final String Tag="recycler view adapter";
    public ArrayList<String>usernames=new ArrayList<>();
    public ArrayList<String>all_usernames=new ArrayList<>();
    public ArrayList<String>availibilities=new ArrayList<>();
    public ArrayList<String>locations=new ArrayList<>();
    public ArrayList<String>bloodgroups=new ArrayList<>();
    public ArrayList<String>contacts=new ArrayList<>();
    public ArrayList<donor>mydonors=new ArrayList<>();
    private Context mycontext;
    public donor_adapter(Context context,ArrayList<String> uname,ArrayList<String> bg,ArrayList<String> loc ,ArrayList<String> avail,ArrayList<String> cont){
        mycontext=context;
        this.usernames=uname;
        this.all_usernames=uname;
        this.bloodgroups=bg;
        this.locations=loc;
        this.availibilities=avail;
        this.contacts=cont;

    }
    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.donorslist,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.userName.setText(usernames.get(position));
        holder.contact.setText(contacts.get(position));
        holder.availability.setText(availibilities.get(position));
        holder.location.setText(locations.get(position));
        holder.bgroup.setText(bloodgroups.get(position));
    }

    @Override
    public int getItemCount() {
        return usernames.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<String> filteredlist=new ArrayList<>();
            if(constraint.toString().isEmpty()){
                filteredlist.addAll(usernames);
            }
            else{
                for(String un:usernames){
                    if(un.toLowerCase().contains(constraint.toString().toLowerCase())){
                        filteredlist.add(un);
                    }

                }
            }
            FilterResults filterResults=new FilterResults();
            filterResults.values=filteredlist;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            usernames.clear();
            usernames.addAll((Collection<? extends String>) results);
            notifyDataSetChanged();
        }

    };

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView userName;
        TextView bgroup;
        TextView location;
        TextView availability;
        TextView contact;
        LinearLayout parentlayout;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            userName = itemView.findViewById(R.id.personName);
            bgroup = itemView.findViewById(R.id.bgroup);
            location = itemView.findViewById(R.id.location);
            availability = itemView.findViewById(R.id.availibilty);
            contact = itemView.findViewById(R.id.contact);
            parentlayout = itemView.findViewById(R.id.parentlayout);

        }

    }
}