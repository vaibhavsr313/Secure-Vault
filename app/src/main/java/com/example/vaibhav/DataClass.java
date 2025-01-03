package com.example.vaibhav;

public class DataClass
    {
    public DataClass(String dataName, String dataMail, String dataPass, String dataImg) {
        this.dataName = dataName;
        this.dataMail = dataMail;
        this.dataPass = dataPass;
        this.dataImg = dataImg;
    }

    private String dataName;
    private String dataMail;
    private String dataPass;
    private String dataImg;

    public String getDataName() {
        return dataName;
    }

    public String getDataMail() {
        return dataMail;
    }

    public String getDataPass() {
        return dataPass;
    }

    public String getDataImg() {
        return dataImg;
    }

    public DataClass()
    {

    }
}
