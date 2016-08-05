package com.app.nike.adapter;

/**
 * Created by muhammad on 8/3/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.nike.R;
import com.app.nike.Slider;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    LayoutInflater mLayoutInflator;

    private String[] titles = {"Shoes One",
            "Shoes Two",
            "Shoes Three",
            "Shoes Four",
            "Shoes Five",
            "Shoes Six",
            "Shoes Seven",
            "Shoes Eight"};

    private String[] details = {"Item one details",
            "Item two details", "Item three details",
            "Item four details", "Item file details",
            "Item six details", "Item seven details",
            "Item eight details"};

    private int[] images = { R.drawable.android_image_1,
            R.drawable.android_image_2,
            R.drawable.android_image_3,
            R.drawable.android_image_4,
            R.drawable.android_image_5,
            R.drawable.android_image_6,
            R.drawable.android_image_7,
            R.drawable.android_image_8 };

    public RecyclerAdapter(Context context) {
        mLayoutInflator = LayoutInflater.from(context);
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        private Context context;
        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            itemDetail =
                    (TextView)itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();
                    {

                        final Intent intent;
                        switch ( position){
                            case 0:
                                intent =  new Intent(context,Slider.class);
                                break;

                            case 1:
                                intent =  new Intent(context, Slider.class);
                                break;

                            default:
                                intent =  new Intent(context, Slider.class);
                                break;
                        }
                        context.startActivity(intent);

                    }

                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = mLayoutInflator.inflate(R.layout.cardview_container, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}