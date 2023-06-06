package com.ajal.dto.response;

import org.springframework.lang.Nullable;

import java.io.Serializable;

public class GenericStringResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String success;

    private final String msg;


    private GenericStringResponse(String success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public static GenericStringResponse ok(@Nullable String msg) {
        return new GenericStringResponse("ok", msg);
    }

    public String getSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }
}
