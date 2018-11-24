package com.atguigu.fileupload.app.exception;

public class InvalidExtNameException extends RuntimeException {

    private static final long serialVersionUID = 4237531199413438879L;

    public InvalidExtNameException(String msg){
        super(msg);
    }

}
