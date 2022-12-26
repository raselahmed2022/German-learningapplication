package com.example.german_exam.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeneralVocabModel {
    @SerializedName("ge_word")
    @Expose
    private String geWord;
    @SerializedName("en_word")
    @Expose
    private String enWord;
    @SerializedName("example")
    @Expose
    private String example;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("category")
    @Expose
    private CategoryModel category;

    public String getGeWord() {
        return geWord;
    }

    public void setGeWord(String geWord) {
        this.geWord = geWord;
    }

    public String getEnWord() {
        return enWord;
    }

    public void setEnWord(String enWord) {
        this.enWord = enWord;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }


}
