package com.example.seoulkorea;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class LanguageFragment extends Fragment {
    //global variable handles playback of all the sound files
    private MediaPlayer mMediaPlayer;

    /**Handles audio focus when playing a sound file*/
    private AudioManager mAudioManager;  //MANAGE AUDIO fOCUS IN THE APP SOLUTION VIDEO - VIDEO TIME 0:15
    private AudioFocusRequest mAudioFocusRequest;
    private AudioAttributes playbackAttributes;
    public final Object mFocusLock = new Object();


    private AudioManager.OnAudioFocusChangeListener
            mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {

        @RequiresApi(api = Build.VERSION_CODES.O) //Version 26 Oreo
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0); //we need to hear all the audio file at a time not just portions
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                // Resume playback
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };

    /**This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };


    public void LanguageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        /** TODO: Insert all the code from the NumberActivity’s onCreate() method after the setContentView method call
         *Do not copy over  super.onCreate(savedInstanceState);
         *                  setContentView(R.layout.word_list);
         */
//Create and setup the {@link AudioManager} to request audio focus
        //MANAGE AUDIO fOCUS IN THE APP SOLUTION VIDEO - VIDEO TIME 0:25
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        // Set AudioFocusRequest Attributes
        playbackAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();
        // Build AudioFocusRequest
        // AUDIOFOCUS_GAIN - request permanent audio focus from the system.
        mAudioFocusRequest = new AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)
                .setAudioAttributes(playbackAttributes)
                .setAcceptsDelayedFocusGain(true)
                .setOnAudioFocusChangeListener(mOnAudioFocusChangeListener)
                .build();


        // Array of words in English
        final ArrayList<MusicandLanguage> words = new ArrayList<MusicandLanguage>();

        // Create a list of words
        words.add(new MusicandLanguage(getResources().getString(R.string.KoreanHello),getResources().getString(R.string.EnglishHello),(getResources().getString(R.string.PronunciationHello)),
                R.raw.phrase_hello));
        words.add(new MusicandLanguage(getResources().getString(R.string.KoreanThankYou),getResources().getString(R.string.EnglishThankYou),(getResources().getString(R.string.PronunciationThankYou)),
                R.raw.phrase_thank_you));
        words.add(new MusicandLanguage(getResources().getString(R.string.KoreanSorry),getResources().getString(R.string.EnglishSorry),(getResources().getString(R.string.PronunciationSorry)),
                R.raw.phrase_im_sorry));
        words.add(new MusicandLanguage(getResources().getString(R.string.KoreanPlease),getResources().getString(R.string.EnglishPlease),(getResources().getString(R.string.PronunciationPlease)),
                R.raw.phrase_please));
        words.add(new MusicandLanguage(getResources().getString(R.string.KoreanCheers),getResources().getString(R.string.EnglishCheers),(getResources().getString(R.string.PronunciationCheers)),
                R.raw.phrase_cheers));
        words.add(new MusicandLanguage(getResources().getString(R.string.KoreanHowmuchisit),getResources().getString(R.string.EnglishHowmuchisit),(getResources().getString(R.string.PronunciationHowmuchisit)),
                R.raw.phrase_how_much_is_this));
        words.add(new MusicandLanguage(getResources().getString(R.string.KoreanThecheckplease),getResources().getString(R.string.EnglishThecheckplease),(getResources().getString(R.string.PronunciationThecheckplease)),
                R.raw.phrase_the_check_please));
        words.add(new MusicandLanguage(getResources().getString(R.string.KoreanWhereisthebathroom),getResources().getString(R.string.EnglishWhereisthebathroom),(getResources().getString(R.string.PronunciationWhereisthebathroom)),
                R.raw.phrase_where_is_the_bathroom));
        words.add(new MusicandLanguage(getResources().getString(R.string.KoreanWon),getResources().getString(R.string.EnglishWon),(getResources().getString(R.string.PronunciationWon)),
                R.raw.phrase_won));
        words.add(new MusicandLanguage(getResources().getString(R.string.KoreanYes),getResources().getString(R.string.EnglishYes),(getResources().getString(R.string.PronunciationYes)),
                R.raw.phrase_yes));
        words.add(new MusicandLanguage(getResources().getString(R.string.KoreanNo),getResources().getString(R.string.EnglishNo),(getResources().getString(R.string.PronunciationNo)),
                R.raw.phrase_no));
        words.add(new MusicandLanguage(getResources().getString(R.string.KoreanWhatisthat),getResources().getString(R.string.EnglishWhatisthat),(getResources().getString(R.string.PronunciationWhatisthat)),
                R.raw.phrase_what_is_that));
        words.add(new MusicandLanguage(getResources().getString(R.string.KoreanWhatisyourname),getResources().getString(R.string.EnglishWhatisyourname),(getResources().getString(R.string.PronunciationWhatisyourname)),
                R.raw.phrase_what_is_your_name));
        words.add(new MusicandLanguage(getResources().getString(R.string.KoreanWhereis),getResources().getString(R.string.EnglishWhereis),(getResources().getString(R.string.PronunciationWhereis)),
                R.raw.phrase_where_is));


        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_language);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        /*
        When user clicks on listView, then the info of the listView and the activity needs to be sent to the NowPlayingActivity.
        */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //When the ListItem is clicked, play the associated song.
                MusicandLanguage word = words.get(position);

                // release the media player if it currently exists because we are about to
                // //play a different sound
                releaseMediaPlayer();

                // Create and setup the {@link AudioManager} to request audio focus for playback
                int focusRequest = mAudioManager.requestAudioFocus(mAudioFocusRequest);

                synchronized (mFocusLock) {
                    // Received audio focus
                    if (focusRequest == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                        // Create and setup the {@link MediaPlayer} for the audio resource
                        // associated with the current word

                        mMediaPlayer = MediaPlayer.create(getActivity(),
                                word.getRawResourceId());
                        mMediaPlayer.start(); //No need to crete prepare();
                        // create() does that automatically

                        //Setup a listener on the media player, so that we can stop and release the
                        //media player one the sound has ended.
                        mMediaPlayer.setOnCompletionListener(mCompletionListener);
                    }
                }
            }
        });
        return rootView;
    }
    @Override
    public void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();

    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            /**
             * //MANAGE AUDIO fOCUS IN THE APP SOLUTION VIDEO - VIDEO TIME 8:00
             */
            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocusRequest(mAudioFocusRequest);
        }
    }
}
