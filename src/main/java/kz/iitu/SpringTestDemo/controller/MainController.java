package kz.iitu.SpringTestDemo.controller;

import kz.iitu.SpringTestDemo.entity.Task;
import kz.iitu.SpringTestDemo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String showHome(Model model) {
        List<Task> tasks = taskService.getAll();
        model.addAttribute("tasks", tasks);
        return "home";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Task task = new Task();
        model.addAttribute(task);
        return "task-form";
    }

    @PostMapping("/add")
    public String addTask(@Valid @ModelAttribute("task") Task task, BindingResult bindingResult) {
        System.out.println(task);
        if (bindingResult.hasErrors()) {
            return "task-form";
        } else {
            taskService.save(task);
            return "redirect:/";
        }
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable Long id, Model model) {
        Task task = taskService.getOne(id);
        model.addAttribute("task", task);
        return "task-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        taskService.delete(id);
        return "redirect:/";
    }
}
