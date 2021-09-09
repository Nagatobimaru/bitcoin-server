package com.whitebear.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiResponseBody<T> implements ApiResponse {
    private T body;
}
