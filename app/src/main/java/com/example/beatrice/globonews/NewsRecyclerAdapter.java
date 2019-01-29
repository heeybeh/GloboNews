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

import java.util.ArrayList;


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


        if (arrayList.get(position).getType().equals("basico"))

        holder.list_title.setText(arrayList.get(position).getContent().getTitle());

//        Bitmap image = BitmapFactory.decodeResource(context.getResources(),
//                model.getImage());
//
//        holder.list_title.setText(model.getTitle());
//        holder.list_location.setText(model.getLocation());
//        holder.list_date.setText(model.getYear());
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