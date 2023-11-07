package com.project.atelier.service;

public interface GenericService<R, T> {

    T save(R request);

    T findById(String id);

}
