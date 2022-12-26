package com.example.german_exam.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelWriting {

    @SerializedName("level")
    @Expose
    private String level;
    @SerializedName("ge_title")
    @Expose
    private String geTitle;
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

    public String getGeDescription() {
        return geDescription;
    }

    public void setGeDescription(String geDescription) {
        this.geDescription = geDescription;
    }


}
