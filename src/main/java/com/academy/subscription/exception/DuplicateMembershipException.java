package com.academy.subscription.exception;

public class DuplicateMembershipException extends RuntimeException{

    public DuplicateMembershipException(String message){
        super(message);
    }
}
