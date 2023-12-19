package com.project.atelier.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface GenericService<R, T> {

    T save(R request) throws NoSuchAlgorithmException;

    T findById(String id);

    List<T> findAll();

    T update(R request, String id);

    void delete(String id);
}
