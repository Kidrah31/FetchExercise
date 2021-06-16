package com.example.fetchexercise.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fetchexercise.R;
import com.example.fetchexercise.models.Data;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{
    Context context;
    List<Data> dataSet;
    public DataAdapter(Context context, List<Data> dataSet) {
        this.context = context;
        this.dataSet = dataSet;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View dataView = LayoutInflater.from(context).inflate(R.layout.item_data, parent, false);
        return new ViewHolder(dataView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data data= dataSet.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvId;
        TextView tvListId;
        TextView tvName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId=itemView.findViewById(R.id.tvId);
            tvListId=itemView.findViewById(R.id.tvListId);
            tvName=itemView.findViewById(R.id.tvName);
        }

        public void bind(Data data) {
            tvId.setText(data.getId());
            tvListId.setText(data.getListId());
            tvName.setText(data.getName());

        }
    }
}
