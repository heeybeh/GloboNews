package com.example.beatrice.globonews.adapters;

import android.view.View;

public class RecyclerViewOnClickListener {
    /** Interface for Item Click over Recycler View Items **/
    public interface OnClickListener {
         void OnItemClick(View view, int position);
    }
}