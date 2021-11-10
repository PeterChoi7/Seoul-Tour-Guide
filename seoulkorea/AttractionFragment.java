package com.example.seoulkorea;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class AttractionFragment extends Fragment {
    public void FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create a list of words
        final ArrayList<AttractionandFood> words = new ArrayList<AttractionandFood>();
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanSeoulTower),getResources().getString(R.string.EnlgishSeoulTower),(getResources().getString(R.string.PopularitySeoulTower)),(getResources().getString(R.string.contact)),
                (getResources().getString(R.string.DescriptionSeoulTower)),R.drawable.seoul_tower));
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanBukchonHanokVillage),getResources().getString(R.string.EnglishBukchonHanokVillage),(getResources().getString(R.string.PopularityBukchonHanokVillage)),getResources().getString(R.string.ContactsBukchonHanokVillage),
                getResources().getString(R.string.DescriptionBukchonHanokVillage),R.drawable.bukchon_hanok_village));
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanGyeongbokgung),getResources().getString(R.string.EnglishGyeongbokgung),(getResources().getString(R.string.PopularityGyeongbokgung)),getResources().getString(R.string.ContactsGyeongbokgung),
                getResources().getString(R.string.DescriptionGyeongbokgung),R.drawable.gyeongbokgung_palace));
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanGwanghwamun),getResources().getString(R.string.EnglishGwanghwamun),(getResources().getString(R.string.PopularityGwanghwamun)),getResources().getString(R.string.ContactsGwanghwamun),
                getResources().getString(R.string.DescriptionGwanghwamun),R.drawable.gwanghwamun));
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanCheonggyecheon),getResources().getString(R.string.EnglishCheonggyecheon),(getResources().getString(R.string.PopularityCheonggyecheon)),getResources().getString(R.string.ContactsCheonggyecheon),
                getResources().getString(R.string.DescriptionCheonggyecheon),R.drawable.cheonggyecheon));
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanBukhansanNationalPark),getResources().getString(R.string.EnglishBukhansanNationalPark),(getResources().getString(R.string.PopularityBukhansanNationalPark)),getResources().getString(R.string.ContactsBukhansanNationalPark),
                getResources().getString(R.string.DescriptionBukhansanNationalPark),R.drawable.bukhansan_national_park));
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanItaewon),getResources().getString(R.string.EnglishItaewon),(getResources().getString(R.string.PopularityItaewon)),getResources().getString(R.string.ContactsItaewon),
                getResources().getString(R.string.DescriptionItaewon),R.drawable.itaewon));
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanGwangjangMarket),getResources().getString(R.string.EnglishGwangjangMarket),(getResources().getString(R.string.PopularityGwangjangMarket)),getResources().getString(R.string.ContactsGwangjangMarket),
                getResources().getString(R.string.DescriptionGwangjangMarket),R.drawable.gwangjang_market));
        words.add(new AttractionandFood(getResources().getString(R.string.KoreanInsadong),getResources().getString(R.string.EnglishInsadong),(getResources().getString(R.string.PopularityInsadong)),getResources().getString(R.string.ContactsInsadong),
                getResources().getString(R.string.DescriptionInsadong),R.drawable.insadong));

        WordAdapter2 adapter = new WordAdapter2(getActivity(), words, R.color.white);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}
