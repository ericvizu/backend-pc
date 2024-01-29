package com.ericvizu.backendpc.services.exceptions;

public class ResourceNotFoundException  extends RuntimeException {
    public ResourceNotFoundException (Object id) {
        super ("Missing resource with id " + id);
    }
}
