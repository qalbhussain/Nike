package com.app.nike.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.nike.R;

import java.util.ArrayList;

/**
 * Created by Shahid on 7/26/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CardHolder> {

    LayoutInflater mLayoutInflater;
    private ArrayList<String> price = new ArrayList<>();
    private ArrayList<String> description = new ArrayList<>();
    private static Integer[] images = {R.drawable.shoes, R.drawable.shoesa,R.drawable.shoesb};

    public RecyclerAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        price = getPrice();
        description = getDescription();
    }

    private ArrayList<String> getDescription() {
        ArrayList<String> des = new ArrayList<>();
        for (int i = 0; i < 3 ; i++) {
            des.add("des :"+1);
        }
        return des;
    }

    private ArrayList<String> getPrice() {
        ArrayList<String> priceb = new ArrayList<>();
        for (int i = 0; i < 3 ; i++) {
            priceb.add("$"+i);
        }
        return priceb;
    }

    @Override
    public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.cardview_container, parent, false);
        CardHolder cardHolder = new CardHolder(view);
        return cardHolder;
    }

    @Override
    public void onBindViewHolder(CardHolder holder, int position) {
        holder.textViewHeading.setText(price.get(position));
        holder.textViewDescription.setText(description.get(position));
        holder.imageView.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public static class CardHolder extends RecyclerView.ViewHolder{

        TextView textViewHeading;
        TextView textViewDescription;
        ImageView imageView;
        public CardHolder(View itemView) {
            super(itemView);

            textViewHeading = (TextView) itemView.findViewById(R.id.tvprice);
            textViewDescription = (TextView) itemView.findViewById(R.id.tvdescription);
            imageView = (ImageView) itemView.findViewById(R.id.thumbnail);
        }
    }
}
