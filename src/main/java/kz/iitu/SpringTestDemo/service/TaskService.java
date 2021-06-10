package kz.iitu.SpringTestDemo.service;

import kz.iitu.SpringTestDemo.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();

    Task getOne(Long id);

    Task save(Task task);

    void delete(Long id);
}
