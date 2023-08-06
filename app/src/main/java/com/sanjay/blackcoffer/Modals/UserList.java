package com.sanjay.blackcoffer.Modals;

public class UserList {

    String userName, location, profession, range, profileProgress, purpose, userMsg, image;

    public UserList() {
    }

    public UserList(String userName, String location, String profession, String range,
                    String profileProgress, String purpose, String userMsg, String image) {
        this.userName = userName;
        this.location = location;
        this.profession = profession;
        this.range = range;
        this.profileProgress = profileProgress;
        this.purpose = purpose;
        this.userMsg = userMsg;
        this.image = image;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getProfileProgress() {
        return profileProgress;
    }

    public void setProfileProgress(String profileProgress) {
        this.profileProgress = profileProgress;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getUserMsg() {
        return userMsg;
    }

    public void setUserMsg(String userMsg) {
        this.userMsg = userMsg;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
