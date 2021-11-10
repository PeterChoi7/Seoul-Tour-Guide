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

public class WordAdapter extends ArrayAdapter<MusicandLanguage>{

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    private int mColorResourceId;


    public WordAdapter(Activity context, ArrayList<MusicandLanguage> words, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }


    @NonNull
    @Override
    //override method
    // position = the number on the screen relating to the reuseable view,
    // convertView= a potential view available for reuse
    // parent = the ListView itself
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        MusicandLanguage currentWord = getItem(position);

        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english_text_view);
        englishTextView.setText(currentWord.getEnglish());

        TextView koreanTextView = (TextView) listItemView.findViewById(R.id.korean_text_view);
        koreanTextView.setText(currentWord.getKorean());

        TextView pronunciationTextView = (TextView) listItemView.findViewById(R.id.pronunciation_text_view);
        pronunciationTextView.setText(currentWord.getpronunciation());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);



        if(currentWord.hasImage()) {
            iconView.setImageResource(currentWord.getImageResourceId());
            iconView.setVisibility(View.VISIBLE);
        }else {
            iconView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}