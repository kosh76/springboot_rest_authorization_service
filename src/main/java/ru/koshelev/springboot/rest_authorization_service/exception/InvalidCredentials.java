package ru.koshelev.springboot.rest_authorization_service.exception;

public class InvalidCredentials extends RuntimeException {
    public InvalidCredentials(String msg){
        super(msg);
    }

}
