package com.aunion_ai.total_project.dto.alignment.response;

import com.aunion_ai.total_project.global.enumeration.Language;
import com.aunion_ai.total_project.global.enumeration.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * packageName    : com.aunion_ai.total_project.dto.alignment.response <br>
 * fileName       : AlignmentSimilarityGetResponse.java <br>
 * author         : chanhoan <br>
 * date           : 25. 5. 01.<br>
 * description    : alignment_similarity 조회에 사용되는 response dto class 입니다. <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.05.01          chanhoan          최초생성<br>
 */
@Getter
@AllArgsConstructor
@Builder
@Schema(name = "AlignmentSimilarityGetResponse", description = "Alignment 유사도 조회 응답 DTO")
@ToString
public class AlignmentSimilarityGetResponse {

    @Schema(description = "유니크 식별자", example = "1")
    private Integer id;

    @Schema(description = "전체 프로젝트 식별자", example = "123")
    private Integer totalProjectId;

    @Schema(description = "레코드 생성 시각", example = "2025-05-01 15:30:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @Schema(description = "원본 입력 음성 Key (S3)", example = "alignment_similarity/alignment_similarity/input_original_video.mp3")
    private String inputOriginalVoiceKey;

    @Schema(description = "원본 입력 텍스트 Key (S3)", example = "alignment_similarity/alignment_similarity/input_original_text.txt")
    private String inputOriginalTextKey;

    @Schema(description = "합성된 출력 음성 Key (S3)", example = "alignment_similarity/alignment_similarity/result_translated_video.mp3")
    private String resultCompoundVoiceKey;

    @Schema(description = "합성된 출력 텍스트 Key (S3)", example = "alignment_similarity/alignment_similarity/result_compound_text.txt")
    private String resultCompoundTextKey;

    @Schema(description = "추론에 걸린 시간 (초)", example = "0.456")
    private BigDecimal inferenceTime;

    @Schema(description = "작업 상태", example = "SUCCESS")
    private TaskStatus status;

    @Schema(description = "audio_comparison.png S3 Key", example = "audio_comparison.png")
    private String audioComparisonKey;

    @Schema(description = "유사도 점수", example = "85")
    private BigDecimal overallScore;

    @Schema(description = "유사도 등급", example = "C")
    private String grade;

    @Schema(description = "휴지(일시정지) 유사도", example = "0.58")
    private BigDecimal pauseSimilarity;

    @Schema(description = "피치(음높이) 유사도", example = "0.77")
    private BigDecimal pitchSimilarity;

    @Schema(description = "에너지(강세) 유사도", example = "0.59")
    private BigDecimal energySimilarity;

    @Schema(description = "리듬 유사도", example = "0.71")
    private BigDecimal rhythmSimilarity;

    @Schema(description = "모음 길이 유사도", example = "0.54")
    private BigDecimal vowelSimilarity;

    @Schema(description = "텍스트 유사도", example = "0.61")
    private BigDecimal textSimilarity;

    @Schema(description = "시간적 유사도", example = "0.74")
    private BigDecimal temporalSimilarity;

    @Schema(description = "발화 속도 유사도", example = "0.58")
    private BigDecimal speakingRateSimilarity;

    @Schema(description = "Prosody 전체 점수", example = "0.60")
    private BigDecimal prosodyOverallScore;

    @Schema(description = "Alignment 전체 점수", example = "0.66")
    private BigDecimal alignmentOverallScore;

    @Schema(
            description = "개선 제안사항",
            example = "1. 휴지 패턴 개선: 원본 음성의 문장 구분과 쉼표 위치에 맞춰 일시정지 패턴을 조정하세요.\n"
                    + "2. 에너지 패턴 개선: 원본 음성에서 강조된 단어나 구문에 맞게 합성 음성의 볼륨과 강세를 조정하세요.\n"
                    + "…"
    )
    private String description;

    @Schema(description = "입력 언어", example = "ENGLISH")
    private Language inputLanguage;

    @Schema(description = "출력 언어", example = "KOREAN")
    private Language outputLanguage;

}
