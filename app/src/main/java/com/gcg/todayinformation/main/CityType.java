package com.gcg.todayinformation.main;

import androidx.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({CityType.ShangHai, CityType.HangZhou, CityType.BeiJing, CityType.ShenZhen})
@Retention(RetentionPolicy.SOURCE)
public @interface CityType {
    public static final int ShangHai = 0;
    public static final int HangZhou = 1;
    public static final int BeiJing = 2;
    public static final int ShenZhen = 3;
}
