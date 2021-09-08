package com.whitebear.common.mapper;

import com.whitebear.model.User;
import com.whitebear.web.request.SignUpRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface UserMapper {
    @Mappings({
            @Mapping(target = "email", source = "request.email"),
            @Mapping(target = "username", source = "request.username"),
    })
    User SignUpRequestToUser(SignUpRequest request);
}
