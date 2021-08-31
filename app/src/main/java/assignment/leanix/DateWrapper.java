package assignment.leanix;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ashutosh Srivastava on 31-Aug-2021 2:10 AM.
 * Project : LeanIX Sample
 * Copyright (c) 2021  All rights reserved.
 */
public enum DateWrapper {

    EEE_MMM_dd_HH_mm_ss_zzz_yyyy("EEE MMM dd HH:mm:ss zzz yyyy"),
    yyyy_MM_dd_T_HH_mm_ss_SSS_Z("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"),
    yyyy_MM_dd_T_HH_mm_ss("yyyy-MM-dd'T'HH:mm:ss"),
    yyyy_MM_dd_HH_mm_ss("yyyy-MM-dd HH:mm:ss"),
    yyyy_MM_dd("yyyy-MM-dd"),
    dd_MMM_yyyy("dd MMM yyyy"),
    hh_mm_a("hh:mm a"),
    MMM_d_yyyy_hh_mm_a("MMM d, yyyy hh:mm a"),
    MMM_d_yyyy_HH_mm_a("MMM d, yyyy HH:mm"),
    HHmm("HHmm"),//~~~ in AutoCheckout
    HH_mm("HH:mm"),//~~~ in AutoCheckout
    HH_mm_ss("HH:mm:ss"),//~~~ in AutoCheckout
    MMM_dd_HH_mm_ss("MMM dd, HH:mm:ss"),
    dd_MM_yyyy_HH_mm_ss("dd-MM-yyyy HH:mm:ss"),
    dd_MM_yyyy_HH_mm_ss_a("dd-MM-yyyy hh:mm:ss a"),
    dd_MMM_yy_hh_mm_a("dd MMM `yy, hh:mm a");

    private static final String TAG = "DateWrapper";
    private final String format;

    DateWrapper(String format) {
        this.format = format;
    }

    public static String getStringFromFormat(DateWrapper format, Date date) {
        if (date == null) return null;
        return getStringFromFormat(format.getValue(), date);
    }

    public static String getStringFromFormat(String format, Date date) {
        if (date == null) return null;
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public String getValue() {
        return format;
    }

}
