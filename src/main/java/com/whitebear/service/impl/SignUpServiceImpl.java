package com.whitebear.service.impl;

import com.whitebear.common.mapper.UserMapper;
import com.whitebear.model.User;
import com.whitebear.repository.UserRepository;
import com.whitebear.service.SignUpService;
import com.whitebear.web.request.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void SignUp(SignUpRequest request) {
        User user = userMapper.SignUpRequestToUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
    }
}
