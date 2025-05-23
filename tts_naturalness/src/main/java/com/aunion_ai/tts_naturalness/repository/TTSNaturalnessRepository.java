package com.aunion_ai.tts_naturalness.repository;

import com.aunion_ai.tts_naturalness.entity.TTSNaturalnessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * packageName    : com.aunion_ai.tts_naturalness.repository<br>
 * fileName       : TTSNaturalnessRepository.java<br>
 * author         : Fiat_lux <br>
 * date           : 2025-04-30<br>
 * description    : TTSNaturalness 의 jpa repository class <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 2025-04-30        Fiat_lux          최초생성<br>
 * <br>
 */
@Repository
public interface TTSNaturalnessRepository extends JpaRepository<TTSNaturalnessEntity, Integer> {
    Optional<TTSNaturalnessEntity> findByTaskName(String taskName);

    List<TTSNaturalnessEntity> findByTotalProjectIdOrderByCreatedDate(Integer totalProjectId);

    TTSNaturalnessEntity findFirstByTotalProjectIdOrderByCreatedDateDesc(Integer totalProjectId);

    boolean existsByTotalProjectId(Integer totalProjectId);

    void deleteAllByTotalProjectId(Integer totalProjectId);
}
