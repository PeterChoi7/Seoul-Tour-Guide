package com.example.seoulkorea;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CategoryStateAdapter extends FragmentStateAdapter {

    public CategoryStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new AttractionFragment();
        } else if (position == 1){
            return new FoodFragment();
        } else if (position == 2){
            return new MusicFragment();
        }else {
            return new LanguageFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

}