package com.example.store.user;

import com.example.store.user.model.UserModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder  =  passwordEncoder;
        this.userRepository  =  userRepository;
    }

    public void registerUser(UserModel userModel) {
        userModel.setPassword(this.passwordEncoder.encode((userModel.getPassword())));
        userRepository.save(userModel);
    }

}
