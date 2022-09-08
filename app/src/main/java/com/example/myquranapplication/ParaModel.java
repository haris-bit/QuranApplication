package com.example.myquranapplication;

public class ParaModel {
    String urduName;
    String englishName;

    public ParaModel(String urduName, String englishName) {
        this.urduName = urduName;
        this.englishName = englishName;
    }

    public String getUrduName() {
        return urduName;
    }

    public void setUrduName(String urduName) {
        this.urduName = urduName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }
}
