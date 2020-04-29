package com.moringa.faqs_project.Network;

import android.appwidget.AppWidgetProviderInfo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//public class APIClient {
//    private static APIClient apiClient;
//    private static Retrofit retrofit;
//
////    private APIClient(){
////        retrofit = new Retrofit.Builder.addConverterFactory(GsonConverterFactory.create()).build();
////    }
//
//    public static synchronized APIClient getInstance(){
//        if(apiClient == null){
//            apiClient = new APIClient();
//        }
//        return apiClient;
//    }
//
//    public M_faq_Interface getApi(){
//        return retrofit.create(M_faq_Interface.class);
//    }
//}
