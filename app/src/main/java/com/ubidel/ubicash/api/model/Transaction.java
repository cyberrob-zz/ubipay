package com.ubidel.ubicash.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by bowenwang on 2017/6/1.
 */

public class Transaction {

    @Getter
    @Setter
    @SerializedName("transactionId")
    @Expose
    public String transactionId;
    @Getter
    @Setter
    @SerializedName("toUserId")
    @Expose
    public String toUserId;
    @Getter
    @Setter
    @SerializedName("toUserPhone")
    @Expose
    public Integer toUserPhone;
    @Getter
    @Setter
    @SerializedName("from")
    @Expose
    public String from;
    @Getter
    @Setter
    @SerializedName("fromUserPhone")
    @Expose
    public Integer fromUserPhone;
    @Getter
    @Setter
    @SerializedName("amount")
    @Expose
    public Double amount;
    @Getter
    @Setter
    @SerializedName("date")
    @Expose
    public String date; // yyyy-mm-dd-T-hh:mm:ss
    /*
     *  Types:
     *  1 ‐> payment
     *  2 ‐> refund
     *  3 ‐> withdrawal
     *  4 ‐> bank charge
     */
    @Getter
    @Setter
    @SerializedName("type")
    @Expose
    public Integer type;

}