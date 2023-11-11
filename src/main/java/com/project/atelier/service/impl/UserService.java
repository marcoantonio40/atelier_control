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

@Service
public class UserService implements GenericService<UserRequest, UserResponse> {

    @Autowired
    UserRepository repository;

    @Override
    public UserResponse save(UserRequest request) throws NoSuchAlgorithmException {
        String encryptedPassword = new BCryptPasswordEncoder().encode(request.getPassword());
        return this.buildResponse(repository.save(User.toModel(request, encryptedPassword)));
    }

    @Override
    public UserResponse findById(String id) {
       return repository.findById(id).map(this::buildResponse).orElse(null);
    }

    private UserResponse buildResponse(User user){
        return new UserResponse(user.getId(), user.isStatus(), user.getType().getRole(), user.getLogin());
    }
}
