package com.aunion_ai.tts_naturalness.global.exception;

import com.github.hyeonjaez.springcommon.exception.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * packageName    : com.aunion_ai.tts_naturalness.global.exception<br>
 * fileName       : TTSNaturalnessErrorCode.java<br>
 * author         : Fiat_lux <br>
 * date           : 2025-04-30<br>
 * description    : TTSNaturalness domain 의 비즈니스 로직의 exception error code 입니다.<br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 2025-04-30        Fiat_lux          최초생성<br>
 * <br>
 */
public enum TTSNaturalnessErrorCode implements ErrorCode {
    TTS_NATURALNESS_NOT_FOUND(HttpStatus.NOT_FOUND, "TTS_NATURALNESS-001", "TTS_NATURALNESS not found");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    TTSNaturalnessErrorCode(HttpStatus httpStatus, String code, String message) {
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
