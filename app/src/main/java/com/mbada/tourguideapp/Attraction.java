package com.mbada.tourguideapp;

/**
 * {@link Attraction} is the tourist attraction object that stores information about an attraction
 */
class Attraction {
    private final String title;
    private final int imageId;

    public Attraction(String title, int imageId, String about){
        this.imageId = imageId;
        this.title = title;
        String about1 = about;
    }

    public String getTitle() {
        return title;
    }

    public int getImageId() {
        return imageId;
    }
}
