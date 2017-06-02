package com.ubidel.ubicash.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by bowenwang on 2017/6/1.
 */

public class HttpResponse {

    @Getter
    @Setter
    @SerializedName("status")
    @Expose
    public Boolean status;

    @Getter
    @Setter
    @SerializedName("error")
    @Expose
    public String error;
}
