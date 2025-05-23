package com.aunion_ai.alignment_similarity.dto.request;

import com.aunion_ai.alignment_similarity.entity.AlignmentSimilarityEntity;
import com.aunion_ai.alignment_similarity.global.enumeration.Language;
import com.aunion_ai.alignment_similarity.global.enumeration.TaskStatus;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * packageName    : com.aunion_ai.alignment_similarity.dto.request <br>
 * fileName       : AlignmentSimilarityRegisterRequest.java <br>
 * author         : chanhoan <br>
 * date           : 25. 5. 01.<br>
 * description    : alignment_similarity 생성에 사용되는 request dto class 입니다. <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.05.01          chanhoan          최초생성<br>
 */
@Getter
@Setter
@NoArgsConstructor
@Schema(name = "AlignmentSimilarityRegisterRequest", description = "Alignment 유사도 등록을 위한 요청 DTO")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AlignmentSimilarityRegisterRequest {

    @Schema(description = "전체 프로젝트 식별자", example = "123")
    @Min(value = 0, message = "전체 프로젝트 식별자는 최소 0입니다.")
    private Integer totalProjectId;

    @Schema(description = "입력 음성 URL", example = "https://s3.example.com/input_voice.mp3")
    @NotBlank(message = "입력 음성 URL은 필수입니다.")
    @Size(min = 1, max = 255, message = "입력 음성 URL은 최소 1글자, 최대 255글자입니다.")
    private String inputOriginalVoiceKey;

    @Schema(description = "입력 텍스트 URL", example = "https://s3.example.com/input_original_text.txt")
    @NotBlank(message = "입력 텍스트 URL은 필수입니다.")
    @Size(min = 1, max = 255, message = "입력 텍스트 URL은 최소 1글자, 최대 255글자입니다.")
    private String inputOriginalTextKey;

    @Schema(description = "합성 음성 URL", example = "https://s3.example.com/result_compound_voice.mp3")
    @NotBlank(message = "합성 음성 URL은 필수입니다.")
    @Size(min = 1, max = 255, message = "합성 음성 URL은 최소 1글자, 최대 255글자입니다.")
    private String resultCompoundVoiceKey;

    @Schema(description = "합성 텍스트 URL", example = "https://s3.example.com/result_compound_text.txt")
    @NotBlank(message = "합성 텍스트 URL은 필수입니다.")
    @Size(min = 1, max = 255, message = "합성 텍스트 URL은 최소 1글자, 최대 255글자입니다.")
    private String resultCompoundTextKey;

    @Schema(description = "추론에 걸린 시간", example = "0.456")
    @NotNull(message = "추론에 걸린 시간은 필수입니다.")
    @PositiveOrZero(message = "추론에 걸린 시간은 0 이상이어야 합니다.")
    @Digits(integer = 10, fraction = 2, message = "추론에 걸린 시간은 소수점 2자리까지 허용됩니다.")
    private BigDecimal inferenceTime;

    @Schema(description = "작업 상태", example = "SUCCESS")
    @NotBlank(message = "작업 상태는 필수입니다.")
    @Size(min = 1, max = 6, message = "작업 상태는 최소 1글자, 최대 255글자입니다.")
    private TaskStatus status;

    @Schema(description = "작업 이름", example = "alignment_similarity_UUID")
    @NotBlank(message = "작업 이름은 필수입니다.")
    @Size(min = 1, max = 255, message = "작업 이름은 최소 1글자, 최대 255글자입니다.")
    private String taskName;

    @Schema(description = "audio_comparison.png S3 Key", example = "audio_comparison.png")
    @NotBlank(message = "audio_comparison.png S3 Key는 필수입니다..")
    @Size(min = 1, max = 255, message = "audio_comparison.png S3 Key는 최소 1글자, 최대 255글자입니다.")
    private String audioComparisonKey;

    @Schema(description = "유사도 점수", example = "85")
    @NotNull(message = "유사도 점수는 필수입니다.")
    @Digits(integer = 1, fraction = 2, message = "유사도 점수는 소수점 2자리까지 허용됩니다.")
    private BigDecimal overallScore;

    @Schema(description = "유사도 등급", example = "C")
    @NotBlank(message = "유사도 등급은 필수입니다.")
    @Size(min = 1, max = 1, message = "등급은 한 글자여야 합니다.")
    private String grade;

    @Schema(description = "휴지(일시정지) 유사도", example = "0.58")
    @NotNull(message = "휴지 유사도는 필수입니다.")
    @Digits(integer = 1, fraction = 2, message = "소수점 둘째 자리까지 허용됩니다.")
    private BigDecimal pauseSimilarity;

    @Schema(description = "피치(음높이) 유사도", example = "0.77")
    @NotNull(message = "피치 유사도는 필수입니다.")
    @Digits(integer = 1, fraction = 2, message = "소수점 둘째 자리까지 허용됩니다.")
    private BigDecimal pitchSimilarity;

    @Schema(description = "에너지(강세) 유사도", example = "0.59")
    @NotNull(message = "에너지 유사도는 필수입니다.")
    @Digits(integer = 1, fraction = 2, message = "소수점 둘째 자리까지 허용됩니다.")
    private BigDecimal energySimilarity;

    @Schema(description = "리듬 유사도", example = "0.71")
    @NotNull(message = "리듬 유사도는 필수입니다.")
    @Digits(integer = 1, fraction = 2, message = "소수점 둘째 자리까지 허용됩니다.")
    private BigDecimal rhythmSimilarity;

    @Schema(description = "모음 길이 유사도", example = "0.54")
    @NotNull(message = "모음 유사도는 필수입니다.")
    @Digits(integer = 1, fraction = 2, message = "소수점 둘째 자리까지 허용됩니다.")
    private BigDecimal vowelSimilarity;

    @Schema(description = "텍스트 유사도", example = "0.61")
    @NotNull(message = "텍스트 유사도는 필수입니다.")
    @Digits(integer = 1, fraction = 2, message = "소수점 둘째 자리까지 허용됩니다.")
    private BigDecimal textSimilarity;

    @Schema(description = "시간적 유사도", example = "0.74")
    @NotNull(message = "시간적 유사도는 필수입니다.")
    @Digits(integer = 1, fraction = 2, message = "소수점 둘째 자리까지 허용됩니다.")
    private BigDecimal temporalSimilarity;

    @Schema(description = "발화 속도 유사도", example = "0.58")
    @NotNull(message = "발화 속도 유사도는 필수입니다.")
    @Digits(integer = 1, fraction = 2, message = "소수점 둘째 자리까지 허용됩니다.")
    private BigDecimal speakingRateSimilarity;

    @Schema(description = "Prosody 전체 점수", example = "0.60")
    @NotNull(message = "Prosody 전체 점수는 필수입니다.")
    @Digits(integer = 1, fraction = 2, message = "소수점 둘째 자리까지 허용됩니다.")
    private BigDecimal prosodyOverallScore;

    @Schema(description = "Alignment 전체 점수", example = "0.66")
    @NotNull(message = "Alignment 전체 점수는 필수입니다.")
    @Digits(integer = 1, fraction = 2, message = "소수점 둘째 자리까지 허용됩니다.")
    private BigDecimal alignmentOverallScore;

    @Schema(
            description = "개선 제안사항",
            example = "1. 휴지 패턴 개선: 원본 음성의 문장 구분과 쉼표 위치에 맞춰 일시정지 패턴을 조정하세요.\n"
                    + "2. 에너지 패턴 개선: 원본 음성에서 강조된 단어나 구문에 맞게 합성 음성의 볼륨과 강세를 조정하세요.\n"
                    + "…"
    )
    @NotBlank(message = "개선 제안사항은 필수입니다.")
    @Size(max = 10000, message = "개선 제안사항은 최대 10000글자입니다.")
    private String description;

    @Schema(description = "입력 언어 코드", example = "KOREAN")
    @NotBlank(message = "입력 언어는 필수입니다.")
    @Size(min = 1, max = 7, message = "입력 언어는 최대 7글자입니다.")
    private Language inputLanguage;

    @Schema(description = "출력 언어 코드", example = "ENGLISH")
    @NotBlank(message = "출력 언어는 필수입니다.")
    @Size(min = 1, max = 7, message = "출력 언어는 최대 7글자입니다.")
    private Language outputLanguage;

    public static AlignmentSimilarityEntity toAlignmentSimilarityEntity(AlignmentSimilarityRegisterRequest request) {
        return AlignmentSimilarityEntity.builder()
                .totalProjectId(request.getTotalProjectId())
                .inputOriginalVoiceKey(request.getInputOriginalVoiceKey())
                .inputOriginalTextKey(request.getInputOriginalTextKey())
                .resultCompoundVoiceKey(request.getResultCompoundVoiceKey())
                .resultCompoundTextKey(request.getResultCompoundTextKey())
                .inferenceTime(request.getInferenceTime())
                .status(request.getStatus())
                .taskName(request.getTaskName())
                .audioComparisonKey(request.getAudioComparisonKey())
                .overallScore(request.getOverallScore())
                .grade(request.getGrade())
                .pauseSimilarity(request.getPauseSimilarity())
                .pitchSimilarity(request.getPitchSimilarity())
                .energySimilarity(request.getEnergySimilarity())
                .rhythmSimilarity(request.getRhythmSimilarity())
                .vowelSimilarity(request.getVowelSimilarity())
                .textSimilarity(request.getTextSimilarity())
                .temporalSimilarity(request.getTemporalSimilarity())
                .speakingRateSimilarity(request.getSpeakingRateSimilarity())
                .prosodyOverallScore(request.getProsodyOverallScore())
                .alignmentOverallScore(request.getAlignmentOverallScore())
                .description(request.getDescription())
                .inputLanguage(request.getInputLanguage())
                .outputLanguage(request.getOutputLanguage())
                .build();
    }
}
