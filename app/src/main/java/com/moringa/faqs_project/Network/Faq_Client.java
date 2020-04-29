package com.moringa.faqs_project.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.moringa.faqs_project.Constants.FAQ_BASE_URL;

public class Faq_Client {

    private static Retrofit retrofit = null;
    public static M_faq_Interface getClient(){
        if (retrofit == null){
            retrofit =  new Retrofit.Builder()
                    .baseUrl(FAQ_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(M_faq_Interface.class);
    }
}
