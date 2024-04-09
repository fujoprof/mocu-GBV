package com.mocu.mocu_gbv;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Apis_Connections {

    @FormUrlEncoded
    @POST("get_student_login_verification.php")
    Call<ResponseBody> set_phone_number_validation(@Field("phone_number") String phone_number);
}
