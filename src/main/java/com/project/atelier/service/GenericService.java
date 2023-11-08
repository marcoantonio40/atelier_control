package com.project.atelier.service;

import java.security.NoSuchAlgorithmException;

public interface GenericService<R, T> {

    T save(R request) throws NoSuchAlgorithmException;

    T findById(String id);

}
