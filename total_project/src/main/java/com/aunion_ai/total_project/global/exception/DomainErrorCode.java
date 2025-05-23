package com.aunion_ai.total_project.global.exception;

import com.github.hyeonjaez.springcommon.exception.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * packageName    : com.aunion_ai.total_project.global.exception<br>
 * fileName       : DomainErrorCode.java<br>
 * author         : Fiat_lux<br>
 * date           : 2025-05-08<br>
 * description    :  Domain Error code enum class <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.05.08          Fiat_lux            최초생성<br>
 */
public enum DomainErrorCode implements ErrorCode {

    TOTAL_PROJECT_NOT_FOUND(HttpStatus.NOT_FOUND, "TOTAL_PROJECT-001", "해당하는 값의 Total project 를 찾지 못했습니다. "),

    TTS_REGISTER_FAILED(HttpStatus.BAD_GATEWAY, "TTS-001", "TTS 등록 요청에 실패했습니다."),
    TTS_GET_FAILED(HttpStatus.BAD_GATEWAY, "TTS-002", "TTS get 요청에 실패했습니다."),

    TEXT_REGISTER_FAILED(HttpStatus.BAD_GATEWAY, "TEXT-001", "텍스트 유사도 등록 요청에 실패했습니다."),
    TEXT_GET_FAILED(HttpStatus.BAD_GATEWAY, "TEXT-002", "TEXT get 요청에 실패했습니다."),

    ALIGNMENT_REGISTER_FAILED(HttpStatus.BAD_GATEWAY, "ALIGNMENT-001", "정렬 유사도 등록 요청에 실패했습니다."),
    ALIGNMENT_GET_FAILED(HttpStatus.BAD_GATEWAY, "ALIGNMENT-002", "ALIGNMENT get 요청에 실패했습니다."),

    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    DomainErrorCode(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
