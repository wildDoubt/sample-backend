package xyz.wonyeong.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.wonyeong.api.dto.CreateToDoRequestDto;
import xyz.wonyeong.api.dto.UpdateToDoRequestDto;
import xyz.wonyeong.api.service.ToDoService;
import xyz.wonyeong.api.dto.ToDo;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;

    @PostMapping("/api/todo")
    public ResponseEntity<ToDo> createToDo(@RequestBody CreateToDoRequestDto createToDoRequestDto) {
        ToDo createdTodo = toDoService.create(createToDoRequestDto);

        return ResponseEntity.ok()
                .body(createdTodo);
    }

    @GetMapping("/api/todos")
    public ResponseEntity<List<ToDo>> getAllToDoList() {
        List<ToDo> toDoList = toDoService.getAll();

        return ResponseEntity.ok()
                .body(toDoList);
    }

    @DeleteMapping("/api/todo/{todoId}")
    public ResponseEntity<ToDo> deleteToDo(@PathVariable long todoId) {
        toDoService.delete(todoId);

        return ResponseEntity.ok()
                .build();
    }

    @PatchMapping("/api/todo")
    public ResponseEntity<ToDo> updateToDo(@RequestBody UpdateToDoRequestDto updateToDoRequestDto) {
        ToDo updatedToDo = toDoService.changeCompletedStatus(updateToDoRequestDto);

        return ResponseEntity.ok()
                .body(updatedToDo);
    }

    @GetMapping("/health-check")
    public ResponseEntity<Void> checkStatus(){
        return ResponseEntity.ok().build();
    }
}
