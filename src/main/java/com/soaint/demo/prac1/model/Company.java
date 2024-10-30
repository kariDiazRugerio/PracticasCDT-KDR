package com.soaint.demo.prac1.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {
    private String nameC;
    private String catchPhrase;
    private String bs;


    public Company(String name, String catchPhrase, String bs) {
        this.nameC = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public String getNameC() {
        return nameC;
    }

    public void setNameC(String name) {
        this.nameC = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }
}
