package com.example.seoulkorea;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    //global variable for mediaplayer
    private MediaPlayer mMediaPlayer;

    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        final ViewPager2 viewPager = (ViewPager2) findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabs);

        // Create an adapter that knows which fragment should be shown on each page
        CategoryStateAdapter adapter = new CategoryStateAdapter(this);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        /**
         * A mediator to link a TabLayout with a ViewPager2. The mediator will synchronize the ViewPager2's
         * position with the selected tab when a tab is selected, and the TabLayout's scroll position when
         * the user drags the ViewPager2. TabLayoutMediator will listen to ViewPager2's OnPageChangeCallback
         * to adjust tab when ViewPager2 moves. TabLayoutMediator listens to TabLayout's
         * OnTabSelectedListener to adjust VP2 when tab moves. TabLayoutMediator listens to RecyclerView's
         * AdapterDataObserver to recreate tab content when dataset changes.
         *
         * <p>Establish the link by creating an instance of this class, make sure the ViewPager2 has an
         * adapter and then call {@link #attach()} on it. Instantiating a TabLayoutMediator will only create
         * the mediator object, {@link #attach()} will link the TabLayout and the ViewPager2 together. When
         * creating an instance of this class, you must supply an implementation of {@link
         * TabConfigurationStrategy} in which you set the text of the tab, and/or perform any styling of the
         * tabs that you require. Changing ViewPager2's adapter will require a {@link #detach()} followed by
         * {@link #attach()} call. Changing the ViewPager2 or TabLayout will require a new instantiation of
         * TabLayoutMediator.
         */

        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {

                    /**TabConfigurationStrategy{}  -
                     * A callback interface that must be implemented to set the text and styling of newly created
                     * tabs.
                     * Called to configure the tab for the page at the specified position. Typically calls {@link
                     * TabLayout.Tab#setText(CharSequence)}, but any form of styling can be applied.
                     *
                     * @param tab The Tab which should be configured to represent the title of the item at the given
                     *     position in the data set.
                     * @param position The position of the item within the adapter's data set.
                     */
                    @Override public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        if (position == 0) {
                            tab.setText("Attractions");
                        }else if (position == 1){
                            tab.setText("Foods");
                        }else if (position == 2) {
                            tab.setText("Music");
                        }else{
                            tab.setText("Language");
                        }
                    }
                }).attach();
    }

    //Find the View object that shows the different view categories (from the Resource layout files)
    // Call the setListenerForActivity method to attach a clickListener to each View Activity


    /*
    The following line of code is a composite of a bunch of things. Originally we had a class
     NumbersClickListener, that implemented OnClickListener, and had a method that created the method onClick.
    Then we created the object here, and then set the Numbers View to have a click listener.
     The code line below does all of that in one line, and wraps it up in another method that you
     can use for each Activity.
     activitys is a class variable that is set to the activity class name (ex. NumbersActivity.class)
    */
    public void setListenerForActivity(View view, final Class activitys){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, activitys);
                startActivity(numbersIntent);
            }
        });
    }
}