package com.example.seoulkorea;

public class AttractionandFood {
    /** Variable for the presence of an image in the object*/
    private static final int NO_IMAGE_PROVIDED = -1;

    private String pTitle;

    private String pTitle2;

    private String pPopularity;

    private String pContact;

    private String pDescription;

    private int mImageResourceId = NO_IMAGE_PROVIDED;


    /**
     * Constructor for pages without images
     * @param title is the name of the place
     * @param popularity is the popularity of the place
     * @param contact is the contact information
     * @param description is the description
     * @param image is the image.
     */
    public AttractionandFood(String title, String title2, String popularity, String contact, String description, int image){
        pTitle = title;
        pTitle2 = title2;
        pPopularity = popularity;
        pContact = contact;
        pDescription  = description;
        mImageResourceId = image;
    }

    public AttractionandFood(String title, String title2, String popularity, String description, int image){
        pTitle = title;
        pTitle2 = title2;
        pPopularity = popularity;
        pDescription  = description;
        mImageResourceId = image;
    }

    /** getter Method for the Default translation for the word*/
    public String getpTitle(){
        return pTitle;
    }

    public String getpTitle2(){
        return pTitle2;
    }

    public String getpPopularity(){
        return pPopularity;
    }

    public String getpContact(){
        return pContact;
    }

    public String getpDescription(){
        return pDescription;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public boolean hasImage() {
        return (mImageResourceId != NO_IMAGE_PROVIDED);
    }
}
