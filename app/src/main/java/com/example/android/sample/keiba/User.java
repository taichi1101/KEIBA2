package com.example.android.sample.keiba;


        import android.widget.ImageView;

        import java.util.Date;

public class User {
    long id;

    String data;
    String username;
    String comment;
    String idnumber;



//    public void User(String score,ImageView imageView,String username){
//
//
//        this.score=score;
//        this.imageView=imageView;
//        this.username=username;
//
//    }



    //userクラスにscore(iine数、score、履歴ゾーン(いいね回数 or 購入数)
    //それをフレンドということにする
    //お気に入りもできる様にする。わからない人もいるだろうし


    String score;
    ImageView imageView;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }


    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }




    public String getData() {
        return data;
    }


    public void setData(String data) {
        this.data = data;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}




