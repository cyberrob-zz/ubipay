package com.ubidel.ubicash.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by bowenwang on 2017/6/1.
 */

public class SignUpInResult {
    @Getter
    @Setter
    @SerializedName("tokenId")
    @Expose
    private String tokenId;
    @Getter
    @Setter
    @SerializedName("userId")
    @Expose
    private String userId;
    @Getter
    @Setter
    @SerializedName("userDetails")
    @Expose
    private UserDetails userDetails;

    @Getter
    @Setter
    @SerializedName("error")
    @Expose
    public String error;
}
