package com.penod.mylibrary.utils;

import com.google.gson.Gson;

/**
 * @author Penoder
 * @date 18-3-3.
 */

public class JsonUtil {

    private String toJson(Object obj) {
        return new Gson().toJson(obj);
    }

}
