package com.whitebear.web;

import com.whitebear.common.response.ApiResponse;
import com.whitebear.common.response.ApiResponseSuccess;
import com.whitebear.common.utils.Messages;
import com.whitebear.service.SignUpService;
import com.whitebear.web.request.SignUpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Locale;

@Slf4j
@RestController
@RequestMapping("api")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @Autowired
    private Messages messages;


    private final String MESSAGE_USER_SIGNUP_SUCCESS = "response.message.user.signup.success";

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignUpRequest request) {
//        signUpService.SignUp(request);
        ApiResponse apiResponse = new ApiResponseSuccess(messages.getMessage(MESSAGE_USER_SIGNUP_SUCCESS, null));
        return ResponseEntity.ok(apiResponse);
    }
}
