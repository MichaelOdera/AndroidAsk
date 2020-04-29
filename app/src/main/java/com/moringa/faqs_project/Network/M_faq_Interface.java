package com.moringa.faqs_project.Network;

import com.moringa.faqs_project.models.Answer;
import com.moringa.faqs_project.models.QuestionSearchResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface M_faq_Interface {
    @GET("api/v1/question")
    Call<List<QuestionSearchResponse>> getQuestions();


    @GET("api/v1/answer")
    Call<List<Answer>> getAnswer(
    );

    @FormUrlEncoded
    @POST("api/v1/question")
    Call <QuestionSearchResponse> postQuestion(@Field("title") String title,
                                 @Field("body") String body);

    @FormUrlEncoded
    @POST("api/v1/answer")
    Call<Answer> postAnswer(@Field("body") String body);
}
