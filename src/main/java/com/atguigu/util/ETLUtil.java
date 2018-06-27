package com.atguigu.util;

/**
 * Created by Administrator on 2018/5/21.
 */
public class ETLUtil {

    public static String ETLString(String line) {

        String[] split = line.split("\t");

        if (split.length < 9) return null;
        split[3] = split[3].replace(" ", "");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (i < 9) {
                if (i == split.length - 1) {
                    sb.append(split[i]);
                } else {
                    sb.append(split[i] + "\t");
                }
            } else {
                if (i == split.length - 1) {
                    sb.append(split[i]);
                } else {
                    sb.append(split[i] + "&");
                }
            }
        }

        return sb.toString();
    }

}
