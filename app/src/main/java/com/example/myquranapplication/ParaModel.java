package com.example.myquranapplication;

public class ParaModel {
    String paraNumber;
    String paraName;

    public ParaModel(String paraNumber, String paraName) {
        this.paraNumber = paraNumber;
        this.paraName = paraName;
    }

    public String getParaNumber() {
        return paraNumber;
    }

    public void setParaNumber(String paraNumber) {
        this.paraNumber = paraNumber;
    }

    public String getParaName() {
        return paraName;
    }

    public void setParaName(String paraName) {
        this.paraName = paraName;
    }
}
