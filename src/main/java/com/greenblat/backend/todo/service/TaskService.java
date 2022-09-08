package com.greenblat.backend.todo.service;

import com.greenblat.backend.todo.entity.Task;
import com.greenblat.backend.todo.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service

@Transactional
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository repository) {
        this.taskRepository = repository;
    }


    public List<Task> findAll(String email) {
        return taskRepository.findByUserEmailOrderByTitleAsc(email);
    }

    public Task add(Task task) {
        return taskRepository.save(task);
    }

    public Task update(Task task) {
        return taskRepository.save(task);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }


    public Page<Task> findByParams(String text, Integer completed, Long priorityId, Long categoryId, String email, Date dateFrom, Date dateTo, PageRequest paging) {
        return taskRepository.findByParams(text, completed, priorityId, categoryId, email, dateFrom, dateTo, paging);
    }

    public Task findById(Long id) {
        return taskRepository.findById(id).get();
    }


}
