package com.example.beatrice.globonews;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ListViewHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener {

    public TextView list_title, list_chapeu, list_date;
    public ImageView list_imageView;
    public RelativeLayout listLayout;

    private RecyclerViewOnClickListener.OnClickListener onClickListener;

    public ListViewHolder(View view) {
        super(view);

        this.list_title =  view.findViewById(R.id.list_title);
        this.list_chapeu = view.findViewById(R.id.list_chapeu);
        this.list_date = view
                .findViewById(R.id.list_desc);
        this.list_imageView = view
                .findViewById(R.id.list_imageview);

        this.listLayout = view.findViewById(R.id.list_layout);

        this.listLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (onClickListener != null) {

            onClickListener.OnItemClick(v, getAdapterPosition());
        }
    }

    public void setClickListener(RecyclerViewOnClickListener.OnClickListener onClickListener) {

        this.onClickListener = onClickListener;
    }
}