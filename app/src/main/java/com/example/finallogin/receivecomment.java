package com.example.finallogin;

public class receivecomment {

    String commentuserid;
    String comment;
    String commentdate;


    public String getCommentuserid() {
        return commentuserid;
    }

    public void setCommentuserid(String commentuserid) {
        this.commentuserid = commentuserid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(String commentdate) {
        this.commentdate = commentdate;
    }

    public receivecomment(String commentuserid, String comment, String commentdate) {
        this.commentuserid = commentuserid;
        this.comment = comment;
        this.commentdate = commentdate;
    }
}
