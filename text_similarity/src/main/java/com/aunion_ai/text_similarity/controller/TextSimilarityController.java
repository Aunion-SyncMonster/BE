package com.aunion_ai.text_similarity.controller;

import com.aunion_ai.text_similarity.dto.request.TextSimilarityRegisterRequest;
import com.aunion_ai.text_similarity.dto.response.TextGetResponse;
import com.aunion_ai.text_similarity.dto.response.TextSimilarityGetResponse;
import com.aunion_ai.text_similarity.dto.response.TextSimilarityRegisterResponse;
import com.aunion_ai.text_similarity.service.TextSimilarityService;
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
 * packageName    : com.aunion_ai.text_similarity.controller <br>
 * fileName       : TextSimilarityController.java <br>
 * author         : chanhoan <br>
 * date           : 25. 4. 30.<br>
 * description    : text_similarity controller class 입니다. <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.04.30          chanhoan          최초생성<br>
 */
@RestController
@RequestMapping("/api/text-similarities")
@RequiredArgsConstructor
@Tag(name = "텍스트 유사도 평가 모델 API", description = "텍스트 유사도 평가 모델을 실행하고 조회하는 API")
public class TextSimilarityController {

    private final TextSimilarityService textSimilarityService;

    /**
     * 텍스트 유사도를 등록하는 API 입니다.
     *
     * @param request 텍스트 유사도 등록 요청 객체
     * @return 텍스트 유사도 등록 응답 객체
     * @see TextSimilarityRegisterRequest
     * @see TextSimilarityRegisterResponse
     */
    @Operation(summary = "텍스트 유사도 등록", description = "사용자가 입력한 원문에 대해 유사도 평가를 실행하고, 그 결과를 저장합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "텍스트 유사도 등록 성공",
                    content = @Content(schema = @Schema(implementation = TextSimilarityRegisterResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청",
                    content = @Content(schema = @Schema(hidden = true)))
    })
    @PostMapping
    public ResponseEntity<?> registerTextSimilarity(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "유사도 등록을 위한 요청 객체 (원문, 목표 언어 등)", required = true, content = @Content(schema = @Schema(implementation = TextSimilarityRegisterRequest.class)))
                                                    @RequestBody TextSimilarityRegisterRequest request) {
        TextSimilarityRegisterResponse response = textSimilarityService.registerTextSimilarity(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }


    /**
     * 텍스트 유사도를 조회하는 API 입니다.
     *
     * @param taskName 조회할 작업 이름
     * @return 텍스트 유사도 조회 응답 객체
     * @see TextSimilarityGetResponse
     */
    @Operation(summary = "텍스트 유사도 조회", description = "등록된 작업 이름으로 평가된 유사도 결과를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "텍스트 유사도 조회 성공",
                    content = @Content(schema = @Schema(implementation = TextSimilarityGetResponse.class))),
            @ApiResponse(responseCode = "404", description = "해당 작업을 찾을 수 없음",
                    content = @Content(schema = @Schema(hidden = true)))
    })
    @GetMapping("/{taskName}")
    public ResponseEntity<?> getTextSimilarity(@Parameter(description = "조회할 작업의 고유 이름 (taskName)", required = true)
                                               @PathVariable(name = "taskName") String taskName) {
        TextSimilarityGetResponse response = textSimilarityService.getTextSimilarity(taskName);
        return ApiResponseUtil.ok("Text similarity retrieve successfully", response);
    }

    /**
     * 프로젝트 ID 기준으로 등록된 텍스트 유사도 결과 리스트를 조회하는 API입니다.
     *
     * @param totalProjectId 총 프로젝트 ID
     * @return 텍스트 유사도 응답 리스트
     */
    @Operation(summary = "프로젝트 ID 기준 텍스트 유사도 목록 조회", description = "totalProjectId를 기준으로 생성일 순으로 정렬된 텍스트 유사도 결과 리스트를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공",
                    content = @Content(schema = @Schema(implementation = TextSimilarityGetResponse.class)))
    })
    @GetMapping("/project/{totalProjectId}")
    public ResponseEntity<?> getTextSimilarityByTotalProjectId(
            @Parameter(description = "총 프로젝트 ID", required = true)
            @PathVariable Integer totalProjectId) {

        List<TextSimilarityGetResponse> response =
                textSimilarityService.getTextSimilarityByTotalProjectIdOrderByCreatedDate(totalProjectId);
        return ResponseEntity.ok(response);
    }

    /**
     * 프로젝트 ID 기준으로 가장 최근에 등록된 텍스트 유사도 결과 하나를 조회하는 API입니다.
     *
     * @param totalProjectId 총 프로젝트 ID
     * @return 최신 텍스트 유사도 결과
     */
    @Operation(summary = "최신 텍스트 유사도 조회", description = "totalProjectId 기준으로 가장 최근에 생성된 텍스트 유사도 결과 1건을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공",
                    content = @Content(schema = @Schema(implementation = TextGetResponse.class)))
    })
    @GetMapping("/project/{totalProjectId}/latest")
    public ResponseEntity<?> getTextPageByTotalProjectId(
            @Parameter(description = "총 프로젝트 ID", required = true)
            @PathVariable Integer totalProjectId) {

        TextGetResponse response =
                textSimilarityService.getTextByTotalProjectOrderByCreatedDateLimit1(totalProjectId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{totalProjectId}")
    public ResponseEntity<?> deleteByTotalProjectId(@PathVariable Integer totalProjectId) {
        textSimilarityService.deleteByTotalProjectId(totalProjectId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

}
