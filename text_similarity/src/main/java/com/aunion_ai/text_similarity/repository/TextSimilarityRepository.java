package com.aunion_ai.text_similarity.repository;

import com.aunion_ai.text_similarity.entity.TextSimilarityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * packageName    : com.aunion_ai.text_similarity.repository <br>
 * fileName       : TextSimilarityRepository.java <br>
 * author         : chanhoan <br>
 * date           : 25. 4. 30.<br>
 * description    : text_similarity repository class 입니다. <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.04.30          chanhoan          최초생성<br>
 */
@Repository
public interface TextSimilarityRepository extends JpaRepository<TextSimilarityEntity, Integer> {

    Optional<TextSimilarityEntity> findByTaskName(String taskName);

    List<TextSimilarityEntity> findByTotalProjectIdOrderByCreatedDate(Integer totalProjectId);

    TextSimilarityEntity findFirstByTotalProjectIdOrderByCreatedDateDesc(Integer totalProjectId);

    boolean existsByTotalProjectId(Integer totalProjectId);

    void deleteAllByTotalProjectId(Integer totalProjectId);
}
