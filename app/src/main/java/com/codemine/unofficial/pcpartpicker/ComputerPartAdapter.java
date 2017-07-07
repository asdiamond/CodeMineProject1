package com.codemine.unofficial.pcpartpicker;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by doter on 5/5/2017.
 */

public class ComputerPartAdapter extends RecyclerView.Adapter<ComputerPartAdapter.ComputerPartViewHolder> {
    public ArrayList<String[]> stringArrayList = new ArrayList<>();
    public ArrayList<String> urls = new ArrayList<>();
    public Context context;

    public ComputerPartAdapter(String[][] arr, ArrayList<String> urls, Context context) {//add url
        this.stringArrayList = new ArrayList<>(Arrays.asList(arr));
        this.urls = urls;
        this.context = context;
    }

    @Override
    public ComputerPartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);
        return new ComputerPartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ComputerPartViewHolder holder, int position) {
        String[] curr = stringArrayList.get(position);

        holder.url = "https://pcpartpicker.com/product/" + urls.get(position);//setup ViewHolder
        //TODO set image dynamically
        holder.computer_part_img.setImageResource(R.drawable.no_image);
        //set data from String[] to views
        for (int i = 0; i < curr.length; i++) {
            holder.textViews[i].setText(curr[i]);
        }

        try {
            //TODO add null checks (shouldnt be necessary but for a failsafe)
            final Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(holder.url));
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(browserIntent);
                }
            });
        } catch (NullPointerException e){
            e.printStackTrace();
            Log.i("Uri FAILED", curr[0]);
        }
    }

    @Override
    public int getItemCount() {
        return stringArrayList.size();
    }

    public static class ComputerPartViewHolder extends RecyclerView.ViewHolder {

        ImageView computer_part_img;
        TextView[] textViews;
        CardView cardView;
        String url;

        public ComputerPartViewHolder(View view) {
            super(view);

            cardView = (CardView)view.findViewById(R.id.card_view);

            //TODO change the image programatically
            computer_part_img = (ImageView)view.findViewById(R.id.card_view_img);

            //TODO set the number of textviews programatically
            //Hint try using the curr.length
            //TODO add a textview to the end thats empty, needs some buffer space
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.card_view_linear_layout);
            textViews = new TextView[9];
            for (int i = 0; i < textViews.length; i++) {
                textViews[i] = new TextView(view.getContext());
                linearLayout.setBackgroundColor(Color.TRANSPARENT);
                linearLayout.addView(textViews[i]);
            }
        }

    }

}
