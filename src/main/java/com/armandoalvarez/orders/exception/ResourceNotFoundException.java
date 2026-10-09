package com.armandoalvarez.orders.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public static ResourceNotFoundException of(String entity, String field, Object id) {
        return new ResourceNotFoundException(entity + "object not found with " + field + " equals " + id);
    }
}
