package com.example.hitesh.popularmoviesp1.Models;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.hitesh.popularmoviesp1.Activities.MainActivityFragment;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hitesh on 05-03-2016.
 */
public class Movie implements Parcelable {

    private int id;
    private String title; // original_title
    private String image; // poster_path
    private String image2; // backdrop_path
    private String overview;
    private int rating; // vote_average
    private String date; // release_date


    public Movie() {

    }


    public Movie(JSONObject movie) throws JSONException {
        this.id = movie.getInt("id");
        this.title = movie.getString("original_title");
        this.image = movie.getString("poster_path");
        this.image2 = movie.getString("backdrop_path");
        this.overview = movie.getString("overview");
        this.rating = movie.getInt("vote_average");
        this.date = movie.getString("release_date");
    }


    public Movie(Cursor cursor) {
        this.id = cursor.getInt(MainActivityFragment.COL_MOVIE_ID);
        this.title = cursor.getString(MainActivityFragment.COL_TITLE);
        this.image = cursor.getString(MainActivityFragment.COL_IMAGE);
        this.image2 = cursor.getString(MainActivityFragment.COL_IMAGE2);
        this.overview = cursor.getString(MainActivityFragment.COL_OVERVIEW);
        this.rating = cursor.getInt(MainActivityFragment.COL_RATING);
        this.date = cursor.getString(MainActivityFragment.COL_DATE);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(image);
        dest.writeString(image2);
        dest.writeString(overview);
        dest.writeInt(rating);
        dest.writeString(date);
    }

    public static final Parcelable.Creator<Movie> CREATOR
            = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    private Movie(Parcel in) {
        id = in.readInt();
        title = in.readString();
        image = in.readString();
        image2 = in.readString();
        overview = in.readString();
        rating = in.readInt();
        date = in.readString();
    }
}
