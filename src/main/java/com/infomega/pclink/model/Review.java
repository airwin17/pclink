package com.infomega.pclink.model;

public class Review {
    private String name;
    private String comment;
    private int rating;
    private String date;
    private String profilePic;
    
    public Review(String name, String comment, int rating, String date, String profilePic) {
        this.name = name;
        this.comment = comment;
        this.rating = rating;
        this.date = date;
        this.profilePic = profilePic;
    }
    public Review() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
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
    public String getProfilePic() {
        return profilePic;
    }
    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }
    @Override
    public String toString() {
        return "{" +
            "\"name\":\"" + name + "\"," +
            "\"comment\":\"" + comment + "\"," +
            "\"rating\":\"" + rating + "\"," +
            "\"date\":\"" + date + "\"," +
            "\"profilePic\":\"" + profilePic + "\"" +
            "}";
    }
}
