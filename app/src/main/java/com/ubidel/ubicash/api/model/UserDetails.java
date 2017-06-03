package com.ubidel.ubicash.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by bowenwang on 2017/6/1.
 */

public class UserDetails {
    @Getter
    @Setter
    @SerializedName("userId")
    @Expose
    public String userId;
    @Getter
    @Setter
    @SerializedName("firstName")
    @Expose
    public String firstName;
    @Getter
    @Setter
    @SerializedName("lastName")
    @Expose
    public String lastName;
    @Getter
    @Setter
    @SerializedName("phone")
    @Expose
    public Double phone;
    @Getter
    @Setter
    @SerializedName("verified")
    @Expose
    public Boolean verified;    // phone number verified
    @Getter
    @Setter
    @SerializedName("bverified")
    @Expose
    public Boolean bverified;    // verified by bank
    @Getter
    @Setter
    @SerializedName("type")
    @Expose
    public Integer type;
    @Getter
    @Setter
    @SerializedName("sex")
    @Expose
    public String sex;
    @Getter
    @Setter
    @SerializedName("balance")
    @Expose
    public Integer balance;

    @Getter
    @Setter
    @SerializedName("error")
    @Expose
    public String error;
}
