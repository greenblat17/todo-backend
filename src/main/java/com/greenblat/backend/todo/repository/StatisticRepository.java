package com.greenblat.backend.todo.repository;

import com.greenblat.backend.todo.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long> {

    Statistic findByUserEmail(String email);
}
