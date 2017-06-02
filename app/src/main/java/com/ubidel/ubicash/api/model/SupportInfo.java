package com.ubidel.ubicash.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by bowenwang on 2017/6/1.
 */

public class SupportInfo {

    public class BankBranch {

        @Getter
        @Setter
        @SerializedName("address")
        @Expose
        public String address;

    }

    @Getter
    @Setter
    @SerializedName("support")
    @Expose
    public List<Integer> support = null;

    @Getter
    @Setter
    @SerializedName("bank_branches")
    @Expose
    public List<BankBranch> bankBranches = null;
}
