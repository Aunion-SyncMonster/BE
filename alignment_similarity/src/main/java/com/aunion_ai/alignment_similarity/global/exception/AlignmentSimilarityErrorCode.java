package com.aunion_ai.alignment_similarity.global.exception;

import com.github.hyeonjaez.springcommon.exception.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * packageName    : com.aunion_ai.alignment_similarity.global.exception <br>
 * fileName       : AlignmentSimilarityErrorCode.java <br>
 * author         : chanhoan <br>
 * date           : 25. 5. 01.<br>
 * description    : alignment_similarity error code enum class 입니다. <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.05.01          chanhoan          최초생성<br>
 */
public enum AlignmentSimilarityErrorCode implements ErrorCode {
    ALIGNMENT_SIMILARITY_NOT_FOUND(HttpStatus.NOT_FOUND, "ALIGNMENT-SIMILARITY-001", "Alignment similarity not found.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    AlignmentSimilarityErrorCode(HttpStatus httpStatus, String code, String message) {
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
