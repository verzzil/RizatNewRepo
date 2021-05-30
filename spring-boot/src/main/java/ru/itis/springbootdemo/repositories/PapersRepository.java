package ru.itis.springbootdemo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.springbootdemo.models.Paper;

import java.util.List;

public interface PapersRepository extends JpaRepository<Paper, Long> {

    @Query("select paper from Paper paper where " +
            "(:q = 'empty' or UPPER(paper.description) like UPPER(concat('%', :q, '%')) " +
            "              or UPPER(paper.title) like UPPER(concat('%', :q, '%')))")
    Page<Paper> search(@Param("q") String q, Pageable pageable);

    List<Paper> findAllByOrderByIdDesc();

    List<Paper> findAllByTitleLikeOrderByIdDesc(String template);

    @Query(
            nativeQuery = true,
            value = "select * from paper where user_id = :userId"
    )
    List<Paper> findPapersFromUserId(Long userId);
}

