package com.madantiwari.topic5task.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.madantiwari.topic5task.R;
import com.madantiwari.topic5task.model.Values;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DatasViewHolder>{
    Context mContext;
    List<Values> dataList = new ArrayList<>();

    public DataAdapter(Context mContext, List<Values> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public DatasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_recycler,parent,false);
        return new DatasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DatasViewHolder holder, int position) {
        final Values values = dataList.get(position);
        holder.Cimgdata.setImageResource(values.getImageId());
        holder.txtName.setText(values.getName());
        holder.txtAge.setText(values.getAge());
        holder.txtGender.setText(values.getGender());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class DatasViewHolder extends RecyclerView.ViewHolder{
        CircleImageView Cimgdata;
        TextView txtName, txtAge, txtGender;
       // ImageButton btnDelete;

        public DatasViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtAge = itemView.findViewById(R.id.txtAge);
            txtGender = itemView.findViewById(R.id.textView);
            Cimgdata = itemView.findViewById(R.id.imageView);
            //btnDelete = itemView.findViewById(R.id.delete);
        }
    }
}
