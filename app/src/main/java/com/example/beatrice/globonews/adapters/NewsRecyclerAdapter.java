package com.example.beatrice.globonews.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.beatrice.globonews.R;
import com.example.beatrice.globonews.fragments.NewsWebViewFragment;
import com.example.beatrice.globonews.models.ItemsModel;

import java.util.ArrayList;
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

        long seconds = new Date().getTime() - Long.parseLong(arrayList.get(position).getAge());
        long timeSecs = (seconds % 3600) / 60 ;
        String timeText;

        holder.list_chapeu.setText(arrayList.get(position).getContent().getChapeu().getLabel());

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

        holder.setClickListener((view, position1) -> {
            switch (view.getId()) {
                case R.id.list_layout:

                    FragmentManager fm = ((FragmentActivity)context).getSupportFragmentManager();
                    FragmentTransaction transaction = fm.beginTransaction();
                    transaction.replace(R.id.fragment_content, new NewsWebViewFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();
                    break;
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