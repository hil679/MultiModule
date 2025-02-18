package dev.be.modulecommon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
클라이언트와 정해놓은 기본 코드
 */
@AllArgsConstructor
@Getter
public enum CodeEnum {
    SUCCESS("0000", "success"),
    UNKNOWN_ERROR("9999", "UNKNOWN_ERROR");

    private String code;
    private String message;
}
