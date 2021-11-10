package com.example.seoulkorea;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class FoodFragment extends Fragment {
    public void FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create a list of words

        final ArrayList<AttractionandFood> words = new ArrayList<AttractionandFood>();
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanBibimbap),getResources().getString(R.string.EnglishBibimbap),(getResources().getString(R.string.PopularityBibimbap)),
                (getResources().getString(R.string.DescriptionBibimbap)),R.drawable.bibimbap));
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanBingsu),getResources().getString(R.string.EnglishBingsu),(getResources().getString(R.string.PopularityBingsu)),
                (getResources().getString(R.string.DescriptionBingsu)),R.drawable.bingsu));
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanKoreanFriedChickenBeer),getResources().getString(R.string.EnglishKoreanFriedChickenBeer),(getResources().getString(R.string.PopularityKoreanFriedChickenBeer)),
                (getResources().getString(R.string.DescriptionKoreanFriedChickenBeer)),R.drawable.chimaek));
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanGanjangGejang),getResources().getString(R.string.EnglishGanjangGejang),(getResources().getString(R.string.PopularityGanjangGejang)),
                (getResources().getString(R.string.DescriptionGanjangGejang)),R.drawable.ganjang_gejang));
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanKoreanBBQ),getResources().getString(R.string.EnglishKoreanBBQ),(getResources().getString(R.string.PopularityKoreanBBQ)),
                (getResources().getString(R.string.DescriptionKoreanBBQ)),R.drawable.korean_bbq));
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanJajangmyeon),getResources().getString(R.string.EnglishJajangmyeon),(getResources().getString(R.string.PopularityJajangmyeon)),
                (getResources().getString(R.string.DescriptionJajangmyeon)),R.drawable.jajangmyeon));
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanJapchae),getResources().getString(R.string.EnglishJapchae),(getResources().getString(R.string.PopularityJapchae)),
                (getResources().getString(R.string.DescriptionJapchae)),R.drawable.japchae));
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanJokbal),getResources().getString(R.string.EnglishJokbal),(getResources().getString(R.string.PopularityJokbal)),
                (getResources().getString(R.string.DescriptionJokbal)),R.drawable.jokbal));
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanKimchi),getResources().getString(R.string.EnglishKimchi),(getResources().getString(R.string.PopularityKimchi)),
                (getResources().getString(R.string.DescriptionKimchi)),R.drawable.kimchi));
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanNaengmyeon),getResources().getString(R.string.EnglishNaengmyeon),(getResources().getString(R.string.PopularityNaengmyeon)),
                (getResources().getString(R.string.DescriptionNaengmyeon)),R.drawable.naengmyeon));
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanPajeon),getResources().getString(R.string.EnglishPajeon),(getResources().getString(R.string.PopularityPajeon)),
                (getResources().getString(R.string.DescriptionPajeon)),R.drawable.pajeon));
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanSannakji),getResources().getString(R.string.EnglishSannakji),(getResources().getString(R.string.PopularitySannakji)),
                (getResources().getString(R.string.DescriptionSannakji)),R.drawable.sannakji));
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanTteokbokki),getResources().getString(R.string.EnglishTteokbokki),(getResources().getString(R.string.PopularityTteokbokki)),
                (getResources().getString(R.string.DescriptionTteokbokki)),R.drawable.tteokbokki));

        WordAdapter2 adapter = new WordAdapter2(getActivity(), words, R.color.white);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}
