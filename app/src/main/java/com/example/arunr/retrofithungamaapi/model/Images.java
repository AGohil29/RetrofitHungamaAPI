package com.example.arunr.retrofithungamaapi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by arun.r on 16-02-2018.
 */

public class Images {
    @SerializedName("image")
    private String image;
    @SerializedName("width")
    private Integer width;
    @SerializedName("height")
    private Integer height;
    @SerializedName("extn")
    private String extn;

    public Images(String image, Integer width, Integer height, String extn){
        this.image = image;
        this.width = width;
        this.height = height;
        this.extn = extn;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getExtn() {
        return extn;
    }

    public void setExtn(String extn) {
        this.extn = extn;
    }
}
