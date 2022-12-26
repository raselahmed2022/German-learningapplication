package com.example.german_exam.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.nio.file.Path;

public class ModelSpeaking {


    @SerializedName("level")
    @Expose
    private String level;
    @SerializedName("ge_title")
    @Expose
    private String geTitle;
    @SerializedName("en_description")
    @Expose
    private String enDescription;
    @SerializedName("ge_description")
    @Expose
    private String geDescription;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getGeTitle() {
        return geTitle;
    }

    public void setGeTitle(String geTitle) {
        this.geTitle = geTitle;
    }

    public String getEnDescription() {
        return enDescription;
    }

    public void setEnDescription(String enDescription) {
        this.enDescription = enDescription;
    }

    public String getGeDescription() {
        return geDescription;
    }

    public void setGeDescription(String geDescription) {
        this.geDescription = geDescription;
    }
}
