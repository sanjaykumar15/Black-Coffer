package com.sanjay.blackcoffer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sanjay.blackcoffer.Modals.UserList;
import com.sanjay.blackcoffer.R;

import java.util.ArrayList;

public class ExploreListAdapter extends RecyclerView.Adapter<ExploreListAdapter.ViewHolder> {

    Context context;
    String key;
    int[] pcStatus = {15,20,25,50,60,30,55};
    /*
    Instead of this array we should get the data and append in array list of UserList data model
    Eg: ArrayList<UserList> data = new ArrayList<>();
    And this array list should be passed through the constructor from respective page
    */

    public ExploreListAdapter(Context context,String key) {
        this.context = context;
        this.key = key;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_element_template,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExploreListAdapter.ViewHolder holder, int position) {
        holder.profileComplete.setProgress(pcStatus[position]);
        if (key.equals("Business")){
            holder.iconLL.setVisibility(View.VISIBLE);
            holder.liveLocation.setVisibility(View.GONE);
        } else if (key.equals("Merchant")){
            holder.iconLL.setVisibility(View.VISIBLE);
            holder.liveLocation.setVisibility(View.VISIBLE);
        } else {
            holder.iconLL.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return pcStatus.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView userNameTV,locProfessionTV,rangeTV,purposeTV,userMsg,proNameTV;
        ImageView proImg,liveLocation;
        ProgressBar profileComplete;
        LinearLayout iconLL;
        public ViewHolder(View view) {
            super(view);
            userNameTV = view.findViewById(R.id.userNameTV);
            locProfessionTV = view.findViewById(R.id.locProfessionTV);
            rangeTV = view.findViewById(R.id.rangeTV);
            purposeTV = view.findViewById(R.id.purposeTV);
            userMsg = view.findViewById(R.id.userMsg);
            proNameTV = view.findViewById(R.id.proNameTV);
            proImg = view.findViewById(R.id.proImg);
            profileComplete = view.findViewById(R.id.profileComplete);
            liveLocation = view.findViewById(R.id.liveLocation);
            iconLL = view.findViewById(R.id.iconLL);
        }
    }
}
