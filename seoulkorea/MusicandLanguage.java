package com.example.seoulkorea;

public class MusicandLanguage {
    /** Variable for the presence of an image in the object*/
    private static final int NO_IMAGE_PROVIDED = -1;

    private String mTitle;

    private String mTitle2;

    private String mExplanation;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private int mRawResourceId;

    /**
     * Constructor for pages without images
     * @param english is the english word
     * @param korean is the korean word
     * @param pronunciation is the pronunciation
     * @param rawResourceId is the audio pronunciation file associated with the word.
     */
    public MusicandLanguage(String english, String korean, String pronunciation, int rawResourceId){
        mTitle = english;
        mTitle2 = korean;
        mExplanation  = pronunciation;
        mRawResourceId = rawResourceId;
    }

    public MusicandLanguage(String english, String pronunciation, int rawResourceId, int image){
        mTitle = english;
        mExplanation  = pronunciation;
        mRawResourceId = rawResourceId;
        mImageResourceId = image;
    }

    /** getter Method for the English for the word*/
    public String getEnglish(){
        return mTitle;
    }

    /** getter Method for the Korean for the word*/
    public String getKorean(){
        return mTitle2;
    }

    /** getter method for the pronunciation for the word*/
    public String getpronunciation(){
        return mExplanation;
    }

    /** getter Method for the Image for the word*/
    public int getImageResourceId(){
        return mImageResourceId;
    }

    /** getter Method for the audio audio for the word*/
    public int getRawResourceId(){
        return mRawResourceId;
    }

    /** Does our object have an image? Will return true or false*/
    public boolean hasImage() {
        return (mImageResourceId != NO_IMAGE_PROVIDED);
    }
}
