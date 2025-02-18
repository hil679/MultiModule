package dev.be.moduleapi.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import dev.be.modulecommon.enums.CodeEnum;
import lombok.*;

@Setter
@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> {
    private String returnCode;
    private String returnMessage;
    private T info;

    //각각 멤버변수를 받아서 생성자 만드는게 아니라 CodeEnum 객체 하나 받을거라 생성자 직접 생성
    public CommonResponse(CodeEnum ce) {
        setReturnCode(ce.getCode());
        setReturnMessage(ce.getMessage());
    }

    public CommonResponse(T info) {
        setInfo(info);
        setReturnCode(CodeEnum.SUCCESS.getCode());
        setReturnMessage(CodeEnum.SUCCESS.getMessage());
    }

    public CommonResponse(CodeEnum ce, T info) {
        setReturnCode(ce.getCode());
        setReturnMessage(ce.getMessage());
        setInfo(info);
    }
}
