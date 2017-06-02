package com.ubidel.ubicash.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by bowenwang on 2017/6/1.
 */

public class SignUpData {

    @Getter
    @Setter
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @Getter
    @Setter
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @Getter
    @Setter
    @SerializedName("password")
    @Expose
    private String password;
    @Getter
    @Setter
    @SerializedName("phone")
    @Expose
    private Integer phone;
    @Getter
    @Setter
    @SerializedName("sex")
    @Expose
    private String sex;
    @Getter
    @Setter
    @SerializedName("type")
    @Expose
    private Integer type;
}
