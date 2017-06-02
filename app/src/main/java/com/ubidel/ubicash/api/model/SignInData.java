package com.ubidel.ubicash.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by bowenwang on 2017/6/1.
 */

public class SignInData {

    @Getter
    @Setter
    @SerializedName("phone")
    @Expose
    public Integer phone;

    @Getter
    @Setter
    @SerializedName("password")
    @Expose
    public String password;
}
