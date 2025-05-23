package com.aunion_ai.tts_naturalness.entity;

import com.aunion_ai.tts_naturalness.global.entity.BaseEntity;
import com.aunion_ai.tts_naturalness.global.enumeration.TTSApiType;
import com.aunion_ai.tts_naturalness.global.enumeration.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * packageName    : com.aunion_ai.tts_naturalness.entity<br>
 * fileName       : TTSNaturalnessEntity.java<br>
 * author         : Fiat_lux <br>
 * date           : 2025-04-30<br>
 * description    : TTSNaturalness 의 entity class 입니다. <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 2025-04-30        Fiat_lux          최초생성<br>
 * <br>
 */
@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tts_naturalness")
public class TTSNaturalnessEntity extends BaseEntity {

    @Column(name = "total_project_id", nullable = false)
    private Integer totalProjectId;

    @Column(name = "input_original_key", nullable = false, length = 255)
    private String inputOriginalKey;

    @Column(name = "result_translation_text_key", nullable = false, columnDefinition = "TEXT")
    private String resultTranslationTextKey;

    @Column(name = "output_voice_key", nullable = false, length = 255)
    private String outputVoiceKey;

    @Column(name = "mos_score", nullable = false, precision = 3, scale = 2)
    private BigDecimal mosScore;

    @Column(name = "sc_score", nullable = false, precision = 3, scale = 2)
    private BigDecimal scScore;

    @Enumerated(EnumType.STRING)
    @Column(name = "tts_api_type", nullable = false, length = 10)
    private TTSApiType ttsApiType;

    @Column(name = "inference_time", nullable = false, precision = 10, scale = 2)
    private BigDecimal inferenceTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private TaskStatus status;

    @Column(name = "task_name", nullable = false, length = 255)
    private String taskName;

    @Column(name = "stability", nullable = false, precision = 3, scale = 2)
    private BigDecimal stability;

    @Column(name = "similarity_boost", nullable = false, precision = 3, scale = 2)
    private BigDecimal similarityBoost;

    @Column(name = "style", nullable = false, precision = 3, scale = 2)
    private BigDecimal style;

    @Column(name = "use_speaker_boost", nullable = false, columnDefinition = "TINYINT")
    private Boolean useSpeakerBoost;

    @Column(name = "voice_id", nullable = false)
    private String voiceId;

    @Builder
    public TTSNaturalnessEntity(Integer totalProjectId, String inputOriginalKey, String resultTranslationTextKey, String outputVoiceKey, BigDecimal mosScore, BigDecimal scScore, TTSApiType ttsApiType, BigDecimal inferenceTime, TaskStatus status, String taskName, BigDecimal stability, BigDecimal similarityBoost, BigDecimal style, Boolean useSpeakerBoost, String voiceId) {
        this.totalProjectId = totalProjectId;
        this.inputOriginalKey = inputOriginalKey;
        this.resultTranslationTextKey = resultTranslationTextKey;
        this.outputVoiceKey = outputVoiceKey;
        this.mosScore = mosScore;
        this.scScore = scScore;
        this.ttsApiType = ttsApiType;
        this.inferenceTime = inferenceTime;
        this.status = status;
        this.taskName = taskName;
        this.stability = stability;
        this.similarityBoost = similarityBoost;
        this.style = style;
        this.useSpeakerBoost = useSpeakerBoost;
        this.voiceId = voiceId;
    }
}
