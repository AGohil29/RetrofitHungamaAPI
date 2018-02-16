package com.example.arunr.retrofithungamaapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arun.r on 15-02-2018.
 */

public class Movie {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("type")
    private String type;
    @SerializedName("typeid")
    private Integer typeId;
    @SerializedName("lang")
    private String lang;
    @SerializedName("lang_id")
    private String langId;
    @SerializedName("genre")
    private String genre;
    @SerializedName("genre_id")
    private Integer genreId;
    @SerializedName("images")
    private ArrayList<Images> images = new ArrayList<Images>();
    @SerializedName("duration")
    private Integer duration;
    @SerializedName("is_playing")
    private Integer isPlaying;

    public Movie(Integer id, String name, String type, Integer typeId, String lang, String langId,
                 String genre, Integer genreId, ArrayList<Images> images, Integer duration, Integer isPlaying){
        this.id = id;
        this.name = name;
        this.type = type;
        this.typeId = typeId;
        this.lang = lang;
        this.langId = langId;
        this.genre = genre;
        this.genreId = genreId;
        this.images = images;
        this.duration = duration;
        this.isPlaying = isPlaying;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLangId() {
        return langId;
    }

    public void setLangId(String langId) {
        this.langId = langId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getIsPlaying() {
        return isPlaying;
    }

    public void setIsPlaying(Integer isPlaying) {
        this.isPlaying = isPlaying;
    }

    public ArrayList<Images> getImages() {
        return images;
    }

    public void setImages(ArrayList<Images> images) {
        this.images = images;
    }
}
