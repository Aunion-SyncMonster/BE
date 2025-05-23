package com.aunion_ai.total_project.service;

import com.aunion_ai.total_project.dto.alignment.request.AlignmentSimilarityRegisterRequest;
import com.aunion_ai.total_project.dto.alignment.response.AlignmentGetResponse;
import com.aunion_ai.total_project.dto.alignment.response.AlignmentSimilarityGetResponse;
import com.aunion_ai.total_project.dto.alignment.response.AlignmentSimilarityRegisterResponse;
import com.aunion_ai.total_project.dto.text.request.TextSimilarityRegisterRequest;
import com.aunion_ai.total_project.dto.text.response.TextGetResponse;
import com.aunion_ai.total_project.dto.text.response.TextSimilarityGetResponse;
import com.aunion_ai.total_project.dto.text.response.TextSimilarityRegisterResponse;
import com.aunion_ai.total_project.dto.tts.request.TTSNaturalnessRegisterRequest;
import com.aunion_ai.total_project.dto.tts.response.TTSGetResponse;
import com.aunion_ai.total_project.dto.tts.response.TTSNaturalnessGetResponse;
import com.aunion_ai.total_project.dto.tts.response.TTSNaturalnessRegisterResponse;
import com.aunion_ai.total_project.global.PropertiesGetURI;
import com.aunion_ai.total_project.global.exception.DomainErrorCode;
import com.github.hyeonjaez.springcommon.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * packageName    : com.aunion_ai.total_project.service<br>
 * fileName       : null.java<br>
 * author         : SSAFY<br>
 * date           : 2025-05-08<br>
 * description    :  <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * <br>
 * <br>
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class WebClientHandler {
    private final WebClient.Builder webClientBuilder;
    private final PropertiesGetURI propertiesGetURI;

    public AlignmentSimilarityRegisterResponse requestPostAlignment(AlignmentSimilarityRegisterRequest registerRequest) {
        Mono<AlignmentSimilarityRegisterResponse> alignmentSimilarityRegisterResponseMono = webClientBuilder.build()
                .post()
                .uri(propertiesGetURI.getAlignment().getPost())
                .bodyValue(registerRequest)
                .retrieve()
                .bodyToMono(AlignmentSimilarityRegisterResponse.class);

        return alignmentSimilarityRegisterResponseMono.blockOptional()
                .orElseThrow(() -> new BusinessException(DomainErrorCode.ALIGNMENT_REGISTER_FAILED));
    }

    public TextSimilarityRegisterResponse requestPostText(TextSimilarityRegisterRequest registerRequest) {
        Mono<TextSimilarityRegisterResponse> textSimilarityRegisterResponseMono = webClientBuilder.build()
                .post()
                .uri(propertiesGetURI.getText().getPost())
                .bodyValue(registerRequest)
                .retrieve()
                .bodyToMono(TextSimilarityRegisterResponse.class);
        return textSimilarityRegisterResponseMono.blockOptional()
                .orElseThrow(() -> new BusinessException(DomainErrorCode.TEXT_REGISTER_FAILED));
    }

    public TTSNaturalnessRegisterResponse requestPostTTS(TTSNaturalnessRegisterRequest registerRequest) {
        Mono<TTSNaturalnessRegisterResponse> ttsNaturalnessRegisterResponseMono = webClientBuilder.build()
                .post()
                .uri(propertiesGetURI.getTts().getPost())
                .bodyValue(registerRequest)
                .retrieve()
                .bodyToMono(TTSNaturalnessRegisterResponse.class);

        return ttsNaturalnessRegisterResponseMono.blockOptional()
                .orElseThrow(() -> new BusinessException(DomainErrorCode.TTS_REGISTER_FAILED));
    }

    public List<AlignmentSimilarityGetResponse> requestGetAlignmentListByTotalProjectId(Integer totalProjectId) {
        String uri = propertiesGetURI.getAlignment().getGet() + "/" + totalProjectId;

        log.info("propertiesGetURI.getAlignment().getGet(): {}", propertiesGetURI.getAlignment().getGet() + "/" + totalProjectId);

        return webClientBuilder.build()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(AlignmentSimilarityGetResponse.class)
                .collectList()
                .blockOptional()
                .orElseThrow(() -> new BusinessException(DomainErrorCode.ALIGNMENT_GET_FAILED));
    }

    public List<TextSimilarityGetResponse> requestGetTextListByTotalProjectId(Integer totalProjectId) {
        String uri = propertiesGetURI.getText().getGet() + "/" + totalProjectId;

        log.info("propertiesGetURI.getText().getGet(): {}", propertiesGetURI.getText().getGet() + "/" + totalProjectId);

        return webClientBuilder.build()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(TextSimilarityGetResponse.class)
                .collectList()
                .blockOptional()
                .orElseThrow(() -> new BusinessException(DomainErrorCode.TEXT_GET_FAILED));
    }

    public List<TTSNaturalnessGetResponse> requestGetTTSListByTotalProjectId(Integer totalProjectId) {
        String uri = propertiesGetURI.getTts().getGet() + "/" + totalProjectId;

        log.info("propertiesGetURI.getTts().getGet(): {}", propertiesGetURI.getTts().getGet() + "/" + totalProjectId);

        return webClientBuilder.build()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(TTSNaturalnessGetResponse.class)
                .collectList()
                .blockOptional()
                .orElseThrow(() -> new BusinessException(DomainErrorCode.TTS_GET_FAILED));
    }

    public AlignmentGetResponse requestGetAlignmentByTotalProjectId(Integer totalProjectId) {
        String uri = propertiesGetURI.getAlignment().getGet() + "/" + totalProjectId + "/latest";

        log.info("propertiesGetURI.getAlignment().getGet(): {}", propertiesGetURI.getAlignment().getGet() + "/" + totalProjectId + "/latest");

        return webClientBuilder.build()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(AlignmentGetResponse.class)
                .blockOptional()
                .orElse(null);
    }

    public TextGetResponse requestGetTextByTotalProjectId(Integer totalProjectId) {
        String uri = propertiesGetURI.getText().getGet() + "/" + totalProjectId + "/latest";

        log.info("propertiesGetURI.getText().getGet(): {}", propertiesGetURI.getText().getGet() + "/" + totalProjectId + "/latest");

        return webClientBuilder.build()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(TextGetResponse.class)
                .blockOptional()
                .orElse(null);
    }

    public TTSGetResponse requestGetTTSByTotalProjectId(Integer totalProjectId) {
        String uri = propertiesGetURI.getTts().getGet() + "/" + totalProjectId + "/latest";

        log.info("propertiesGetURI.getTts().getGet(): {}", propertiesGetURI.getTts().getGet() + "/" + totalProjectId + "/latest");

        return webClientBuilder.build()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(TTSGetResponse.class)
                .blockOptional()
                .orElse(null);
    }

    public void requestDeleteTTSByTotalProjectId(Integer totalProjectId) {
        String uri = propertiesGetURI.getTts().getGet() + "/" + totalProjectId;

        log.info("Sending DELETE request to: {}", uri);

        webClientBuilder.build()
                .delete()
                .uri(uri)
                .retrieve()
                .toBodilessEntity()
                .doOnError(error -> log.warn("tts 삭제 중 오류 발생: {}", error.getMessage()))
                .onErrorResume(e -> Mono.empty())
                .block();
    }

    public void requestDeleteTextByTotalProjectId(Integer totalProjectId) {
        String uri = propertiesGetURI.getText().getGet() + "/" + totalProjectId;

        log.info("Sending DELETE request to: {}", uri);

        webClientBuilder.build()
                .delete()
                .uri(uri)
                .retrieve()
                .toBodilessEntity()
                .doOnError(error -> log.warn("Text 삭제 중 오류 발생: {}", error.getMessage()))
                .onErrorResume(e -> Mono.empty())
                .block();
    }

    public void requestDeleteAlignmentByTotalProjectId(Integer totalProjectId) {
        String uri = propertiesGetURI.getAlignment().getGet() + "/" + totalProjectId;

        log.info("Sending DELETE request to: {}", uri);

        webClientBuilder.build()
                .delete()
                .uri(uri)
                .retrieve()
                .toBodilessEntity()
                .doOnError(error -> log.warn("Alignment 삭제 중 오류 발생: {}", error.getMessage()))
                .onErrorResume(e -> Mono.empty())
                .block();
    }


}
