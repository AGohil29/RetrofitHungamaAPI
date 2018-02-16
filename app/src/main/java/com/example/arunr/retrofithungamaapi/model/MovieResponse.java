package com.example.arunr.retrofithungamaapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arun.r on 15-02-2018.
 */

public class MovieResponse {
    @SerializedName("status")
    private Integer status;
    @SerializedName("message")
    private String message;
    @SerializedName("node")
    private Node node;

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public class Node {
        @SerializedName("epoch")
        private Integer epoch;
        @SerializedName("ts")
        private Integer ts;
        @SerializedName("country")
        private String country;
        @SerializedName("bucketId")
        private Integer bucketId;
        @SerializedName("prioityID")
        private Integer priorityId;
        @SerializedName("data")
        private ArrayList<Movie> data = new ArrayList<>();

        public ArrayList<Movie> getData() {
            return data;
        }

        public void setData(ArrayList<Movie> data) {
            this.data = data;
        }
    }
}