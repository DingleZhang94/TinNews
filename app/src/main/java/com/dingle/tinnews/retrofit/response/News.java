package com.dingle.tinnews.retrofit.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class News implements Parcelable{

    public Source getSource() {
        return source;
    }

    public Source source;
    public String author;
    @NonNull
    public String title;
    public String description;
    public String url;

    @SerializedName("urlToImage")
    public String image;

    @SerializedName("publishedAt")
    public String time;

    public News() {

    }

    protected  News(Parcel in){
        author = in.readString();
        title = in.readString();
        description = in.readString();
        url = in.readString();
        image = in.readString();
        time = in.readString();
    }

    public static final Parcelable.Creator<News> CREATOR = new Parcelable.Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(author);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(url);
        dest.writeString(image);
        dest.writeString(time);
    }


    public String getAuthor() {
        return author;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }

    public String getTime() {
        return time;
    }


}
