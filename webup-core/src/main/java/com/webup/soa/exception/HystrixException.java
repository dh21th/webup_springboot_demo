package com.webup.soa.exception;


public class HystrixException extends Exception{
    public HystrixException(){
        super();
    }
    public HystrixException(String message){
        super(message);
    }
}
