package com.project.atelier.service;

public abstract class AbstractService<R, D> {
    protected abstract R buildResponse(D domain);
}
