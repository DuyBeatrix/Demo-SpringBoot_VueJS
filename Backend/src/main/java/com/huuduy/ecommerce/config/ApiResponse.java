package com.huuduy.ecommerce.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T>
{
    int code;
    String message;
    T result;

    public ApiResponse(String message, HttpStatus httpStatus) {
    }

    public String getTimestamp()
    {
        return LocalDate.now().toString();
    }
}
