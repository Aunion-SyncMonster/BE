package com.aunion_ai.alignment_similarity.repository;

import com.aunion_ai.alignment_similarity.entity.AlignmentSimilarityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * packageName    : com.aunion_ai.alignment_similarity.repository <br>
 * fileName       : AlignmentSimilarityRepository.java <br>
 * author         : chanhoan <br>
 * date           : 25. 5. 01.<br>
 * description    : alignment_similarity repository class 입니다. <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.05.01          chanhoan          최초생성<br>
 */
@Repository
public interface AlignmentSimilarityRepository extends JpaRepository<AlignmentSimilarityEntity, Integer> {
    Optional<AlignmentSimilarityEntity> findByTaskName(String taskName);

    List<AlignmentSimilarityEntity> findByTotalProjectIdOrderByCreatedDate(Integer totalProjectId);

    AlignmentSimilarityEntity findFirstByTotalProjectIdOrderByCreatedDateDesc(Integer totalProjectId);

    boolean existsByTotalProjectId(Integer totalProjectId);

    void deleteAllByTotalProjectId(Integer totalProjectId);
}
