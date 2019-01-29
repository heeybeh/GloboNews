package com.example.beatrice.globonews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class NewsRecyclerAdapter extends RecyclerView.Adapter<ListViewHolder> {
    private ArrayList<ItemsModel> arrayList;
    private Context context;

    public NewsRecyclerAdapter(Context context, ArrayList<ItemsModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);

    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

            holder.list_chapeu.setText(arrayList.get(position).getContent().getChapeu().label);
            holder.list_title.setText(arrayList.get(position).getContent().getTitle());

            if (arrayList.get(position).getContent().getImage() != null) {

                Glide.with(context).load(arrayList.get(position).getContent().getImage().getUrl())
                        .into(holder.list_imageView);

            }

            
//        Bitmap image = BitmapFactory.decodeResource(context.getResources(),
//                model.getImage());
//
//        holder.list_title.setText(model.getTitle());
//        holder.list_location.setText(model.getLocation());

//        holder.list_imageView.setImageBitmap(image);
//
//        holder.setClickListener(new RecyclerViewOnClickListener.OnClickListener() {
//
//            @Override
//            public void OnItemClick(View view, int position) {
//                switch (view.getId()) {
//                    case R.id.list_layout:
//
//                        Toast.makeText(context,
//                                "You have clicked " + model.getTitle(),
//                    s            Toast.LENGTH_LONG).show();
//                        break;
//                }
//            }
//
//        });

    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(
                R.layout.list_customview, viewGroup, false);
        return new ListViewHolder(mainGroup);

    }
}