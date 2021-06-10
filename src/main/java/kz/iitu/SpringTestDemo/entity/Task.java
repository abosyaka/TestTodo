package kz.iitu.SpringTestDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "task")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull(message = "this field must not be empty")
    @Size(min = 1, message = "this field must not be empty")
    private String name;

    @Column(name = "date")
    private LocalDate date = LocalDate.now();

    @Column(name = "priority")
    @NotNull(message = "set the priority")
    private Integer priority = 0;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Boolean status = Boolean.FALSE;

    public Task(String name, Integer priority, String description) {
        this.name = name;
        this.priority = priority;
        this.description = description;
    }
}
