package dev.be.moduleapi.exceptionhandler;

import dev.be.moduleapi.exception.CustomException;
import dev.be.moduleapi.response.CommonResponse;
import dev.be.modulecommon.enums.CodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //@ExceptionHandelr에 있는 객체에 대한 예외 터지면 이를 감지
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public CommonResponse handlerCustomException(CustomException e) {
        return CommonResponse.builder()
                .returnCode(e.getErrorCode())
                .returnMessage(e.getErrorMessage())
                .build();
    }

    //for missing exception (e.g. IllegalException)
    @ExceptionHandler
    public CommonResponse handlerException(Exception e) {
        return CommonResponse.builder()
                .returnCode(CodeEnum.UNKNOWN_ERROR.getCode()) // setting like this on purpose
                .returnMessage(CodeEnum.UNKNOWN_ERROR.getMessage())
                .build();
    }
}
