package com.example.yongqi.demo.studyretrofit;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by yongqi on 2018/2/27.
 */

public class AppStores {

    public interface TaobaoIPService{
        @GET("v2/movie/in_theaters")
        Call<MovieHotBean> getIP();

        @FormUrlEncoded
        @POST("getIpInfo.php")
        Call<IP> postIP(@Field("ip")String ip);
    }


    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.douban.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    static AppStores.TaobaoIPService service = retrofit.create(AppStores.TaobaoIPService.class);
}
