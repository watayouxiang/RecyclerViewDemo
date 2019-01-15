package com.wata.recyclerviewdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/3/17.
 */
public class DataProvider {

    public static List<DataBean> getTestData() {
        List<DataBean> data = new ArrayList<>();
        DataBean bean;
        for (int i = 0; i < 100; i++) {
            bean = new DataBean();
            bean.icon = R.mipmap.ic_launcher;
            bean.name = getRandomString();
            data.add(bean);
        }
        return data;
    }

    private static String getRandomString() {
        //62位数
        String text = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //从1到61的int型随数
        int index = (int) (1 + Math.random() * 61);
        return text.substring(index);
    }

}
