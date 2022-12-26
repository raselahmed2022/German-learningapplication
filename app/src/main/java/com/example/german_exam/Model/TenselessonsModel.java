package com.example.german_exam.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TenselessonsModel {

    @SerializedName("questions")
    @Expose
    private String questions;
    @SerializedName("options")
    @Expose
    private String options;
    @SerializedName("answer")
    @Expose
    private String answer;
    @SerializedName("hint")
    @Expose
    private String hint;

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
