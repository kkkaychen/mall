package com.kaychen.springbootmall.model.response;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static java.util.Objects.requireNonNull;

@Data
public class ApiResponse {
    private final String statusCode;
    private final String message;
    private final Object data;
    private final LocalDateTime timestamp = LocalDateTime.now(ZoneId.of("Asia/Taipei"));

    public ApiResponse(Status statusCode, String message, Object data) {
        this.statusCode = requireNonNull(statusCode, "未指定 status").getStatusCode();
        this.message = requireNonNull(message, statusCode.getDefaultMessage());
        this.data = data;
    }

    @RequiredArgsConstructor
    @Getter
    public enum Status {
        FAILURE("C000", "失敗"),
        SUCCESS("C001", "成功"),
        SUCCESS_NO_CONTENT("C002", "成功，但無回傳內容");

        private final String statusCode;
        private final String defaultMessage;
    }

}
