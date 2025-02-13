package com.training.LearningManagmentSystem.exception;

public class NotFoundInDatabaseException extends Exception{
    public NotFoundInDatabaseException() {
    }

    public NotFoundInDatabaseException(String message) {
        super(message);
    }
}
