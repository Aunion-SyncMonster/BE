package com.aunion_ai.total_project.dto.request;

import com.aunion_ai.total_project.global.enumeration.ProjectType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TotalProjectRegisterRequest {

    @Schema(description = "전체 프로젝트 이름", example = "조커 프로젝트")
    @NotNull(message = "전체 프로젝트 이름은 필수입니다")
    @Size(min = 1, message = "전체 프로젝트 식별자는 1글자 이상, 255글자 이하입니다.")
    private String title;

    @NotBlank
    private ProjectType projectType;

}
