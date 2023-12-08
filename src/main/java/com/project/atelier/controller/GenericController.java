package com.project.atelier.controller;

import com.project.atelier.service.GenericService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public abstract class GenericController<T, S> {

    private final GenericService service;

    protected GenericController(GenericService service) {
        this.service = service;
    }

    @PostMapping(path = "/create")
    ResponseEntity<S> create(@Valid @RequestBody T request) throws NoSuchAlgorithmException {
        return (ResponseEntity<S>) ResponseEntity.ok(service.save(request));
    }

    @GetMapping(path = "/find-by-id/{id}")
    ResponseEntity<S> findById(@Valid @PathVariable(value = "id") String id ){
        return (ResponseEntity<S>) ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(path = "/find-all")
    ResponseEntity<List<S>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping(path = "/update/{id}")
    ResponseEntity<S> update(@PathVariable(value = "id") String id,
                                            @Valid @RequestBody T request)  {
        return (ResponseEntity<S>) ResponseEntity.ok(service.update(request, id));
    }

    @DeleteMapping(path = "/delete/{id}")
    ResponseEntity delete(@PathVariable(value = "id") String id)  {
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
