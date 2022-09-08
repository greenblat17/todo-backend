package com.greenblat.backend.todo.repository;

import com.greenblat.backend.todo.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {

    List<Priority> findByUserEmailOrderByIdAsc(String email);

    @Query("SELECT p FROM Priority p WHERE " +
            "p.user.email=:email AND " +
            "(:title IS NULL OR " +
            ":title='' OR " +
            "LOWER(:title) LIKE LOWER(CONCAT('%', :title, '%') ) )" +
            "ORDER BY p.title ASC")
    List<Priority> findByTitle(@Param(("title")) String title, @Param("email") String email);
}
