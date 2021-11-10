package com.example.seoulkorea;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter2 extends ArrayAdapter<AttractionandFood>{

    private static final String LOG_TAG2 = WordAdapter2.class.getSimpleName();
    private int mColorResourceId2;


    public WordAdapter2(Activity context, ArrayList<AttractionandFood> words, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceId2 = colorResourceId;
    }


    @NonNull
    @Override
    //override method
    // position = the number on the screen relating to the reuseable view,
    // convertView= a potential view available for reuse
    // parent = the ListView itself
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView2 = convertView;
        if(listItemView2 == null) {
            listItemView2 = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item2, parent, false);
        }

        AttractionandFood currentWord2 = getItem(position);

        TextView TitleTextView = (TextView) listItemView2.findViewById(R.id.title_text_view);
        TitleTextView.setText(currentWord2.getpTitle());

        TextView Title2TextView = (TextView) listItemView2.findViewById(R.id.title2_text_view);
        Title2TextView.setText(currentWord2.getpTitle2());

        TextView PopularityTextView = (TextView) listItemView2.findViewById(R.id.popularity_text_view);
        PopularityTextView.setText(currentWord2.getpPopularity());

        TextView ContactTextView = (TextView) listItemView2.findViewById(R.id.contact_info_text_view);
        ContactTextView.setText(currentWord2.getpContact());

        TextView DescriptionTextView = (TextView) listItemView2.findViewById(R.id.description_text_view);
        DescriptionTextView.setText(currentWord2.getpDescription());


        ImageView iconView2 = (ImageView) listItemView2.findViewById(R.id.list_item_icon2);



        if(currentWord2.hasImage()) {
            iconView2.setImageResource(currentWord2.getImageResourceId());
            iconView2.setVisibility(View.VISIBLE);
        }else {
            iconView2.setVisibility(View.GONE);
        }

        View textContainer2 = listItemView2.findViewById(R.id.text_container2);
        int color = ContextCompat.getColor(getContext(), mColorResourceId2);
        textContainer2.setBackgroundColor(color);
        return listItemView2;
    }
}