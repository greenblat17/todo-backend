package com.greenblat.backend.todo.service;

import com.greenblat.backend.todo.entity.Category;
import com.greenblat.backend.todo.entity.Priority;
import com.greenblat.backend.todo.repository.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PriorityService {

    private final PriorityRepository priorityRepository;

    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    public Priority getById(Long id) {
        return priorityRepository.findById(id).get();
    }

    public List<Priority> findAll(String email) {
        return priorityRepository.findByUserEmailOrderByIdAsc(email);
    }

    public List<Priority> findAll(String title, String email) {
        return priorityRepository.findByTitle(title, email);
    }

    @Transactional
    public Priority addPriority(Priority priority) {
        return priorityRepository.save(priority);
    }

    @Transactional
    public Priority updatePriority(Priority priority) {
        return priorityRepository.save(priority);
    }

    @Transactional
    public void deletePriority(Long id) {
        priorityRepository.deleteById(id);
    }


}
