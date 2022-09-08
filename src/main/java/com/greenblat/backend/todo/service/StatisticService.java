package com.greenblat.backend.todo.service;

import com.greenblat.backend.todo.entity.Statistic;
import com.greenblat.backend.todo.repository.StatisticRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class StatisticService {

    private final StatisticRepository statisticRepository;

    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    public Statistic findAll(String email) {
        return statisticRepository.findByUserEmail(email);
    }
}
