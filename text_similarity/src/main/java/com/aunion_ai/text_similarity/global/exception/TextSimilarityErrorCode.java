package com.aunion_ai.text_similarity.global.exception;

import com.github.hyeonjaez.springcommon.exception.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * packageName    : com.aunion_ai.text_similarity.global.exception <br>
 * fileName       : TextSimilarityErrorCode.java <br>
 * author         : chanhoan <br>
 * date           : 25. 4. 30.<br>
 * description    : text_similarity error code enum class 입니다. <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.04.30          chanhoan          최초생성<br>
 */
public enum TextSimilarityErrorCode implements ErrorCode {

    TEXT_SIMILARITY_NOT_FOUND(HttpStatus.NOT_FOUND, "TEXT_SIMILARITY-001", "TextSimilarity not found");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    TextSimilarityErrorCode(HttpStatus httpStatus, String code, String message) {
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
