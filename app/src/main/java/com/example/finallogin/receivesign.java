package com.example.finallogin;

public class receivesign {

    String commentuserid;
    String commentdate;
    String comment;

    public String getCommentuserid() {
        return commentuserid;
    }

    public void setCommentuserid(String commentuserid) {
        this.commentuserid = commentuserid;
    }

    public String getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(String commentdate) {
        this.commentdate = commentdate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public receivesign(String commentuserid, String commentdate,String comment) {
        this.commentuserid = commentuserid;
        this.commentdate = commentdate;
        this.comment=comment;


    }
}
