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

public class MusicFragment extends Fragment {
    //global variable handles playback of all the sound files
    private MediaPlayer mMediaPlayer;

    /**Handles audio focus when playing a sound file*/
    private AudioManager mAudioManager;
    private AudioFocusRequest mAudioFocusRequest;
    private AudioAttributes playbackAttributes;
    public final Object mFocusLock = new Object();

    /**
     * This listener gets triggered whenever the audio focus changes
     */

    private AudioManager.OnAudioFocusChangeListener
            mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {

        @RequiresApi(api = Build.VERSION_CODES.O)
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


    public void MuiscFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

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


        // Array of words
        final ArrayList<MusicandLanguage> words = new ArrayList<MusicandLanguage>();
        // Create a list of words
        words.add(new MusicandLanguage(getResources().getString(R.string.SongDynamite),getResources().getString(R.string.ArtistDynamite),
                R.raw.dynamite,R.drawable.dynamite_album_cover));
        words.add(new MusicandLanguage(getResources().getString(R.string.SongEul),getResources().getString(R.string.ArtistEul),
                R.raw.eul,R.drawable.eul));
        words.add(new MusicandLanguage(getResources().getString(R.string.SongWildFlower),getResources().getString(R.string.ArtistWildFlower),
                R.raw.wild_flower,R.drawable.wild_flower));
        words.add(new MusicandLanguage(getResources().getString(R.string.SongLifeGoesOn),getResources().getString(R.string.ArtistLifeGoesOn),
                R.raw.life_goes_on,R.drawable.life_goes_on));
        words.add(new MusicandLanguage(getResources().getString(R.string.SongDontWorry),getResources().getString(R.string.ArtistDontWorry),
                R.raw.dont_worry,R.drawable.dont_worry));
        words.add(new MusicandLanguage(getResources().getString(R.string.SongLilac),getResources().getString(R.string.ArtistLilac),
                R.raw.lilac,R.drawable.lilac));
        words.add(new MusicandLanguage(getResources().getString(R.string.SongEat),getResources().getString(R.string.ArtistEat),
                R.raw.eat,R.drawable.eat));
        words.add(new MusicandLanguage(getResources().getString(R.string.SongRedFlavor),getResources().getString(R.string.ArtistRedFlavor),
                R.raw.red_flavor,R.drawable.red_flavor));
        words.add(new MusicandLanguage(getResources().getString(R.string.SongDevil),getResources().getString(R.string.ArtistDevil),
                R.raw.deviil,R.drawable.devil));
        words.add(new MusicandLanguage(getResources().getString(R.string.SongFire),getResources().getString(R.string.ArtistFire),
                R.raw.idol,R.drawable.idol));
        words.add(new MusicandLanguage(getResources().getString(R.string.SongIDOL),getResources().getString(R.string.ArtistIDOL),
                R.raw.fire,R.drawable.idol));
        words.add(new MusicandLanguage(getResources().getString(R.string.SongMikrokosmos),getResources().getString(R.string.ArtistMikrokosmos),
                R.raw.mikrokosmos,R.drawable.mikrokosmos));


        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_music);

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

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocusRequest(mAudioFocusRequest);
        }
    }
}
