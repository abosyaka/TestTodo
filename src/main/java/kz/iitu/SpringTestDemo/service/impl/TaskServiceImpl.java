package kz.iitu.SpringTestDemo.service.impl;

import kz.iitu.SpringTestDemo.entity.Task;
import kz.iitu.SpringTestDemo.repository.TaskRepository;
import kz.iitu.SpringTestDemo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAll() {
        return taskRepository.findAllByOrderByPriorityDesc();
    }

    @Override
    public Task getOne(Long id) {
        return taskRepository.getById(id);
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
