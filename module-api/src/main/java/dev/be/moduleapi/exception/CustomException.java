package dev.be.moduleapi.exception;

import dev.be.modulecommon.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class CustomException extends RuntimeException{
    private String errorCode;
    private String errorMessage;

    public CustomException(CodeEnum ce) {
        super(ce.getMessage());
        setErrorCode(ce.getCode());
        setErrorMessage(ce.getMessage());
    }
}
