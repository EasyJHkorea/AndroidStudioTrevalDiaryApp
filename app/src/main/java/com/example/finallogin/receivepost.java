package com.example.finallogin;

import android.graphics.Bitmap;

public class receivepost {

    String address;
    String userid;
    String time;
    String textone;
    String texttwo;
    String textthree;
    String star;
    String ind;
//    String bitmap;




    public receivepost(String address, String userid, String time, String textone, String texttwo, String textthree, String star, String ind) {
        this.address = address;
        this.userid = userid;
        this.time = time;
        this.textone = textone;
        this.texttwo = texttwo;
        this.textthree = textthree;
        this.star = star;
        this.ind=ind;
//        this.bitmap=bitmap;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTime() {
        return time;
    }

    public void setDate(String time) {
        this.time = time;
    }

    public String getTextone() {
        return textone;
    }

    public void setTextone(String textone) {
        this.textone = textone;
    }

    public String getTexttwo() {
        return texttwo;
    }

    public void setTexttwo(String texttwo) {
        this.texttwo = texttwo;
    }

    public String getTextthree() {
        return textthree;
    }

    public void setTextthree(String textthree) {
        this.textthree = textthree;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }
//
    



}
