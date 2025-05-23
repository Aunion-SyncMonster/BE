package com.aunion_ai.alignment_similarity.controller;

import com.aunion_ai.alignment_similarity.dto.request.AlignmentSimilarityRegisterRequest;
import com.aunion_ai.alignment_similarity.dto.response.AlignmentGetResponse;
import com.aunion_ai.alignment_similarity.dto.response.AlignmentSimilarityGetResponse;
import com.aunion_ai.alignment_similarity.dto.response.AlignmentSimilarityRegisterResponse;
import com.aunion_ai.alignment_similarity.service.AlignmentSimilarityService;
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
 * packageName    : com.aunion_ai.alignment_similarity.controller <br>
 * fileName       : AlignmentSimilarityController.java <br>
 * author         : chanhoan <br>
 * date           : 25. 5. 01.<br>
 * description    : alignment_similarity controller class 입니다. <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.05.01          chanhoan          최초생성<br>
 */
@RestController
@RequestMapping("/api/alignment-similarities")
@RequiredArgsConstructor
@Tag(name = "Alignment 유사도 평가 모델 API", description = "Alignment 유사도 평가 모델을 실행하고 조회하는 API")
public class AlignmentSimilarityController {

    private final AlignmentSimilarityService alignmentSimilarityService;

    /**
     * Alignment Similarity 정보를 등록합니다.
     *
     * @param request 등록할 Alignment Similarity 정보가 담긴 요청 객체
     * @return 등록된 AlignmentSimilarityRegisterResponse 객체를 ResponseEntity에 담아 반환
     * 성공 시 201 Created 상태 코드와 함께 응답, 실패 시 예외 처리
     */
    @Operation(summary = "Alignment 유사도 등록", description = "사용자가 입력한 원문, 음성과 합성 텍스트, 음성에 대한 Alignment 유사도 평가를 실행하고, 그 결과를 저장합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Alignment 유사도 등록 성공",
                    content = @Content(schema = @Schema(implementation = AlignmentSimilarityRegisterResponse.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청",
                    content = @Content(schema = @Schema(hidden = true)))
    })
    @PostMapping
    public ResponseEntity<?> registerAlignmentSimilarity(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "유사도 등록을 위한 요청 객체 (원문 텍스트, 음성, 합성 텍스트, 음성 등)", required = true,
                    content = @Content(schema = @Schema(implementation = AlignmentSimilarityRegisterRequest.class)))
            @RequestBody AlignmentSimilarityRegisterRequest request) {

        AlignmentSimilarityRegisterResponse response = alignmentSimilarityService.registerAlignmentSimilarity(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @Operation(summary = "텍스트 유사도 조회", description = "등록된 작업 이름으로 평가된 유사도 결과를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "텍스트 유사도 조회 성공",
                    content = @Content(schema = @Schema(implementation = AlignmentSimilarityGetResponse.class))),
            @ApiResponse(responseCode = "404", description = "해당 작업을 찾을 수 없음",
                    content = @Content(schema = @Schema(hidden = true)))
    })
    @GetMapping("/{taskName}")
    public ResponseEntity<?> getTextSimilarity(@Parameter(description = "조회할 작업의 고유 이름 (taskName)", required = true)
                                               @PathVariable(name = "taskName") String taskName) {
        AlignmentSimilarityGetResponse response = alignmentSimilarityService.getAlignmentSimilarity(taskName);
        return ApiResponseUtil.ok("Text similarity retrieve successfully", response);
    }

    /**
     * 프로젝트 ID를 기준으로 등록된 모든 Alignment 유사도 평가 결과를 조회합니다.
     *
     * @param totalProjectId 총 프로젝트 ID
     * @return 평가 결과 리스트
     */
    @Operation(summary = "전체 Alignment 유사도 결과 조회", description = "프로젝트 ID를 기준으로 등록된 Alignment 유사도 결과 목록을 생성일 오름차순으로 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공",
                    content = @Content(schema = @Schema(implementation = AlignmentSimilarityGetResponse.class)))
    })
    @GetMapping("/project/{totalProjectId}")
    public ResponseEntity<List<AlignmentSimilarityGetResponse>> getAlignmentTotalProjectId(
            @Parameter(description = "총 프로젝트 ID", required = true) @PathVariable Integer totalProjectId) {

        List<AlignmentSimilarityGetResponse> response = alignmentSimilarityService.getAlignmentSimilarityByTotalProjectId(totalProjectId);
        return ResponseEntity.ok(response);
    }

    /**
     * 프로젝트 ID를 기준으로 가장 최근에 등록된 Alignment 유사도 평가 결과를 조회합니다.
     *
     * @param totalProjectId 총 프로젝트 ID
     * @return 최신 평가 결과
     */
    @Operation(summary = "최신 Alignment 유사도 결과 조회", description = "프로젝트 ID를 기준으로 가장 최근 등록된 Alignment 유사도 평가 결과 1건을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공",
                    content = @Content(schema = @Schema(implementation = AlignmentGetResponse.class)))
    })
    @GetMapping("/project/{totalProjectId}/latest")
    public ResponseEntity<AlignmentGetResponse> getAlignmentTotalProjectIdOrderByCreatedDateLimit1(
            @Parameter(description = "총 프로젝트 ID", required = true) @PathVariable Integer totalProjectId) {

        AlignmentGetResponse response = alignmentSimilarityService.getAlignmentByTotalProjectIdOrderByCreatedDateLimit1(totalProjectId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{totalProjectId}")
    public ResponseEntity<?> deleteByTotalProjectId(@PathVariable Integer totalProjectId) {
        alignmentSimilarityService.deleteByTotalProjectId(totalProjectId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
