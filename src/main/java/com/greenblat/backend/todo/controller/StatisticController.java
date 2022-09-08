package com.greenblat.backend.todo.controller;

import com.greenblat.backend.todo.entity.Statistic;
import com.greenblat.backend.todo.service.StatisticService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistic")
public class StatisticController {

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/all")
    public ResponseEntity<Statistic> showAllStatistic(@RequestParam("email") String email) {
        return ResponseEntity.ok(statisticService.findAll(email));
    }
}
