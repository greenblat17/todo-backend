package com.greenblat.backend.todo.controller;

import com.greenblat.backend.todo.entity.Category;
import com.greenblat.backend.todo.entity.Priority;
import com.greenblat.backend.todo.search.CategorySearchValues;
import com.greenblat.backend.todo.search.PrioritySearchValues;
import com.greenblat.backend.todo.service.PriorityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priority")
public class PriorityController {

    private final PriorityService priorityService;

    public PriorityController(PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Priority> findById(@PathVariable("id") Long id) {
        Priority priority = priorityService.getById(id);
        return ResponseEntity.ok(priority);
    }

    @GetMapping("/all")
    public List<Priority> showAllPriority(@RequestParam("email") String email) {
        return priorityService.findAll(email);
    }

    @PostMapping("/add")
    public ResponseEntity<Priority> add(@RequestBody Priority priority) {
        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0) {
            return new ResponseEntity("misses param: title must bu null", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(priorityService.addPriority(priority));
    }

    @PutMapping("/update")
    public ResponseEntity<Priority> update(@RequestBody Priority priority) {

        if (priority.getId() == null || priority.getId() == 0) {
            return new ResponseEntity("missed param: id", HttpStatus.NOT_ACCEPTABLE);
        }

        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }

        priorityService.updatePriority(priority);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Priority> delete(@PathVariable("id") Long id) {
        priorityService.deletePriority(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Priority>> search(@RequestBody PrioritySearchValues prioritySearchValues) {

        if (prioritySearchValues.getEmail() == null || prioritySearchValues.getEmail().trim().length() == 0) {
            return new ResponseEntity("missed param: email", HttpStatus.NOT_ACCEPTABLE);
        }

        List<Priority> priorityByTitle = priorityService.findAll(
                prioritySearchValues.getTitle(), prioritySearchValues.getEmail());

        return  ResponseEntity.ok(priorityByTitle);

    }
}
