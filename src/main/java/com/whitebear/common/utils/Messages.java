package com.whitebear.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Messages {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String code, @Nullable Object[] args) {
        if(args != null) {
            return messageSource.getMessage(code, args, Locale.getDefault());
        }
        return messageSource.getMessage(code, null, Locale.getDefault());
    }
}
