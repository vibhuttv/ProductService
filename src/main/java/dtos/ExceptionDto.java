package dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDto {
    private String message;         // Error Message
    private String resolution;      // How to resolve this Error
}

