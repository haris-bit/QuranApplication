package com.example.myquranapplication;

public class AyatModel {
    private String arabic;
    private String urdu;
    private String english;

    public AyatModel(String arabic, String urdu, String english) {
        this.arabic = arabic;
        this.urdu = urdu;
        this.english = english;
    }

    public String getArabic() {
        return arabic;
    }

    public void setArabic(String arabic) {
        this.arabic = arabic;
    }

    public String getUrdu() {
        return urdu;
    }

    public void setUrdu(String urdu) {
        this.urdu = urdu;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }
}
