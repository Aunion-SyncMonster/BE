package com.aunion_ai.total_project.controller;

import com.aunion_ai.total_project.dto.request.TotalProjectRegisterRequest;
import com.aunion_ai.total_project.dto.request.TotalProjectUpdateRequest;
import com.aunion_ai.total_project.dto.response.TotalProjectDetailResponse;
import com.aunion_ai.total_project.dto.response.TotalProjectPageResponse;
import com.aunion_ai.total_project.dto.response.TotalProjectRegisterResponse;
import com.aunion_ai.total_project.service.TotalProjectService;
import com.github.hyeonjaez.springcommon.response.ApiResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * packageName    : com.aunion_ai.module_total_project.controller<br>
 * fileName       : null.java<br>
 * author         : SSAFY<br>
 * date           : 2025-04-30<br>
 * description    :  <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * <br>
 * <br>
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/total-projects")
public class TotalProjectController {
    private final TotalProjectService totalProjectService;

    @PostMapping
    public ResponseEntity<?> registerTotalProject(@RequestBody TotalProjectRegisterRequest request) {
        TotalProjectRegisterResponse response = totalProjectService.registerTotalProject(request);
        return ApiResponseUtil.created(response);
    }

    @PutMapping
    public ResponseEntity<?> updateTotalProject(@RequestBody TotalProjectUpdateRequest request) {
        TotalProjectRegisterResponse response = totalProjectService.updateTotalProject(request);
        return ApiResponseUtil.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTotalProjectById(@PathVariable Integer id) {
        TotalProjectDetailResponse response = totalProjectService.getTotalProjectDetailById(id);
        return ApiResponseUtil.ok(response);
    }

    @GetMapping
    public ResponseEntity<?> getTotalProjects(@RequestParam(defaultValue = "0") int page) {
        Page<TotalProjectPageResponse> response = totalProjectService.getTotalProjectPageResponse(page);
        return ApiResponseUtil.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTotalProject(@PathVariable Integer id) {
        totalProjectService.deleteTotalProject(id);
        return ApiResponseUtil.noContent();
    }
}
