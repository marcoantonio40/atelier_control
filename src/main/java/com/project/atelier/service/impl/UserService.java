package com.project.atelier.service.impl;

import com.project.atelier.dto.request.UserRequest;
import com.project.atelier.dto.response.UserResponse;
import com.project.atelier.model.User;
import com.project.atelier.repository.UserRepository;
import com.project.atelier.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements GenericService<UserRequest, UserResponse> {

    @Autowired
    UserRepository repository;

    @Override
    public UserResponse save(UserRequest request) throws NoSuchAlgorithmException {
        String encryptedPassword = new BCryptPasswordEncoder().encode("12345678");
        return this.buildResponse(repository.save(User.toModel(request, encryptedPassword)));
    }

    @Override
    public UserResponse findById(String id) {
       return repository.findById(id).map(this::buildResponse).orElse(null);
    }

    @Override
    public List<UserResponse> findAll() {
        return repository.findAll()
                .stream().map(this::buildResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse update(UserRequest request, String id) {
        String encryptedPassword = new BCryptPasswordEncoder().encode("12345678");
        String password = this.repository.findById(id).map(User::getPassword).orElse(encryptedPassword);
        return this.buildResponse(repository.save(User.toModelToUpdate(request, id, password)));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    private UserResponse buildResponse(User user){
        return new UserResponse(user.getId(), user.getName(), user.getCpf(), user.getPhone(), user.getCreatedDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), user.getLogin(), user.getType().toString());
    }
}
