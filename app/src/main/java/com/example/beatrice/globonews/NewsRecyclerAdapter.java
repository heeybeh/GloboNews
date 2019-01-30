package com.example.beatrice.globonews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

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

        long seconds = new Date().getTime() - Long.parseLong(arrayList.get(position).getAge());
        long timeSecs = (seconds % 3600) / 60 ;
        String timeText;

        holder.list_chapeu.setText(arrayList.get(position).getContent().getChapeu().label);

        holder.list_title.setText(arrayList.get(position).getContent().getTitle());

        if (arrayList.get(position).getContent().getImage() != null) {

            holder.list_image_View.setVisibility(View.VISIBLE);
            RequestOptions options = new RequestOptions()
                    .error(R.drawable.ic_launcher)
                    .centerCrop();

            Glide.with(context).load(arrayList.get(position).getContent().getImage().getUrl()).apply(options).into(holder.list_image_View);

        } else {

            holder.list_image_View.setVisibility(View.GONE);
        }

        if (timeSecs >= 60) {

            timeSecs = timeSecs / 60;

            if (timeSecs > 1) {

                timeText = timeSecs + " horas atrás";

            } else {

                timeText = timeSecs + " hora atrás";

            }

        } else {

            if (timeSecs == 1) {

                timeText = timeSecs + " minuto atrás";

            } else if (timeSecs > 1) {

                timeText = timeSecs + " minutos atrás";

            } else {

                timeText = "Alguns segundos atrás";
            }
        }

        holder.list_date.setText(timeText);

        holder.setClickListener(new RecyclerViewOnClickListener.OnClickListener() {

            @Override
            public void OnItemClick(View view, int position) {
                switch (view.getId()) {
                    case R.id.list_layout:

                        Toast.makeText(context, "You have clicked " + arrayList.get(position).getContent().getTitle(), Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.list_customview, viewGroup, false);

        return new ListViewHolder(mainGroup);
    }
}