package com.aunion_ai.tts_naturalness.controller;

import com.aunion_ai.tts_naturalness.dto.request.TTSNaturalnessRegisterRequest;
import com.aunion_ai.tts_naturalness.dto.response.TTSGetResponse;
import com.aunion_ai.tts_naturalness.dto.response.TTSNaturalnessGetResponse;
import com.aunion_ai.tts_naturalness.dto.response.TTSNaturalnessRegisterResponse;
import com.aunion_ai.tts_naturalness.service.TTSNaturalnessService;
import com.github.hyeonjaez.springcommon.response.ApiResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName    : com.aunion_ai.tts_naturalness.controller<br>
 * fileName       : TTSNaturalnessController.java<br>
 * author         : Fiat_lux <br>
 * date           : 2025-04-30<br>
 * description    : TTSNaturalness rest api controller class 입니다. <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 2025-04-30        Fiat_lux          최초생성<br>
 * <br>
 */
@Tag(name = "TTS Naturalness", description = "TTS 자연스러움 평가 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tts-naturalness")
public class TTSNaturalnessController {

    private final TTSNaturalnessService ttsNaturalnessService;

    @Operation(
            summary = "TTS 자연스러움 평가 등록",
            description = "텍스트 유사도 기반의 TTS 평가 요청을 등록합니다."
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "등록 성공",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = TTSNaturalnessRegisterResponse.class)
                    )),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청 형식"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "서버 오류")
    })
    @PostMapping
    public ResponseEntity<?> registerTextSimilarity(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "TTS 자연스러움 등록 요청 바디",
                    required = true,
                    content = @Content(schema = @Schema(implementation = TTSNaturalnessRegisterRequest.class))
            ) @RequestBody TTSNaturalnessRegisterRequest request) {

        TTSNaturalnessRegisterResponse response = ttsNaturalnessService.registerTextSimilarity(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @Operation(summary = "텍스트 유사도 조회", description = "등록된 작업 이름으로 평가된 유사도 결과를 조회합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "텍스트 유사도 조회 성공",
                    content = @Content(schema = @Schema(implementation = TTSNaturalnessGetResponse.class))),
            @ApiResponse(responseCode = "404", description = "해당 작업을 찾을 수 없음",
                    content = @Content(schema = @Schema(hidden = true)))
    })
    @GetMapping("/{taskName}")
    public ResponseEntity<?> getTextSimilarity(@Parameter(description = "조회할 작업의 고유 이름 (taskName)", required = true)
                                               @PathVariable(name = "taskName") String taskName) {
        TTSNaturalnessGetResponse response = ttsNaturalnessService.getTTSNaturalnessByTaskName(taskName);
        return ApiResponseUtil.ok("Text similarity retrieve successfully", response);
    }

    /**
     * 프로젝트 ID로 등록된 모든 TTS 자연스러움 평가 결과를 조회합니다.
     *
     * @param totalProject 총 프로젝트 ID
     * @return 평가 결과 리스트
     */
    @Operation(summary = "전체 TTS 평가 결과 조회", description = "프로젝트 ID를 기준으로 등록된 모든 TTS 자연스러움 평가 결과를 생성일 오름차순으로 조회합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "조회 성공",
                    content = @Content(schema = @Schema(implementation = TTSNaturalnessGetResponse.class)))
    })
    @GetMapping("project/{totalProject}")
    public ResponseEntity<List<TTSNaturalnessGetResponse>> getTextSimilarityByTotalProject(
            @Parameter(description = "총 프로젝트 ID", required = true)
            @PathVariable Integer totalProject) {

        List<TTSNaturalnessGetResponse> response =
                ttsNaturalnessService.getTTSNaturalnessByProjectIdOrderByCreatedDate(totalProject);
        return ResponseEntity.ok(response);
    }

    /**
     * 프로젝트 ID로 가장 최근 등록된 TTS 평가 결과 1건을 조회합니다.
     *
     * @param totalProject 총 프로젝트 ID
     * @return 최신 평가 결과
     */
    @Operation(summary = "최신 TTS 평가 결과 조회", description = "프로젝트 ID를 기준으로 가장 최근에 등록된 TTS 자연스러움 평가 결과 1건을 조회합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "조회 성공",
                    content = @Content(schema = @Schema(implementation = TTSGetResponse.class)))
    })
    @GetMapping("/project/{totalProject}/latest")
    public ResponseEntity<TTSGetResponse> getTextPageByTotalProject(
            @Parameter(description = "총 프로젝트 ID", required = true)
            @PathVariable Integer totalProject) {

        TTSGetResponse response =
                ttsNaturalnessService.getTTSByProjectIdOrderByCreatedDateLimit1(totalProject);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{totalProjectId}")
    public ResponseEntity<?> deleteByTotalProjectId(@PathVariable Integer totalProjectId) {
        ttsNaturalnessService.deleteByTotalProjectId(totalProjectId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
