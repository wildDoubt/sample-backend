package xyz.wonyeong.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.wonyeong.api.dto.ToDo;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    ToDo save(ToDo toDo);

    Optional<ToDo> findById(Long id);

    List<ToDo> findAll();

    void deleteById(Long id);
}
