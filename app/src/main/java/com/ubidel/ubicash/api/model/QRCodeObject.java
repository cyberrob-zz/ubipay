package com.ubidel.ubicash.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by bowenwang on 2017/6/1.
 */

public class QRCodeObject {

    @Getter
    @Setter
    @SerializedName("qr_code")
    @Expose
    public String qrCode;

    @Getter
    @Setter
    @SerializedName("error")
    @Expose
    public String error;
}
