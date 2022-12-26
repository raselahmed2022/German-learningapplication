package com.example.german_exam.DataBase;


import com.example.german_exam.Model.GeneralVocabModel;
import com.example.german_exam.Model.GrammarModel;
import com.example.german_exam.Model.ModalVerbModel;
import com.example.german_exam.Model.ModelReading;
import com.example.german_exam.Model.ModelSpeaking;
import com.example.german_exam.Model.ModelWriting;
import com.example.german_exam.Model.TenseModel;
import com.example.german_exam.Model.TenselessonsModel;
import com.example.german_exam.Model.CategoryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("speaking/{level}")
    Call<List<ModelSpeaking>> getspeakingdata(@Query("level") String speakinglevel);


    @GET("writing/{level}")
    Call<List<ModelWriting>> getwritingdata(@Query("level") String writiinglevel);

    @GET("readingfuck/{level}")
    Call<List<ModelReading>> getreadingdata(@Query("level") String readinglevel);

    @GET("tensepractice")
    Call<List<TenseModel>> gettensedata();

    @GET("tenselessons")
    Call<List<TenselessonsModel>> gettenselessonsdata();

    @GET("modalverb")
    Call<List<ModalVerbModel>> getmodalverbdata();

    @GET("category")
    Call<List<CategoryModel>> getvocabdata();

    @GET("vocabulary/{id}")
    Call<List<GeneralVocabModel>> getgeneralvocabdata(@Query("id") String readinglevel);
    @GET("grammar")
    Call<List<GrammarModel>> getgrammarmodeldata();


}
