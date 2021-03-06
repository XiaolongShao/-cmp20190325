package com.llf.springboot.common.responseUtil;

public class CmpException extends RuntimeException{

    private static final long serialVersionUID = -6370612186038915645L;

    private final ErrorCodeAndMsg response;

    public CmpException(ErrorCodeAndMsg response) {
        this.response = response;
    }
    public ErrorCodeAndMsg getResponse() {
        return response;
    }
}
