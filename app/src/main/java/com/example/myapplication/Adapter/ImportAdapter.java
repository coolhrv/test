package com.example.myapplication.Adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Domain.ImageDownload;
import com.example.myapplication.R;

import java.util.List;

public class ImportAdapter extends RecyclerView.Adapter<ImportAdapter.ViewHolder> {
    Context applicationContext;
    List<ImageDownload> imgList;



    public ImportAdapter(Context applicationContext, List<ImageDownload> imgList) {
       this.applicationContext=applicationContext;
        this.imgList=imgList;

    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(applicationContext).inflate(R.layout.single_imageview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ImportAdapter.ViewHolder holder, int position) {
        Glide.with(applicationContext).load(imgList.get(position).getImg_url()).into(holder.img);



    }

    @Override
    public int getItemCount() {
        return imgList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);;
        }
    }

}
