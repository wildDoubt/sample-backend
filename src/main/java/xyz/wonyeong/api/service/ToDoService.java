package xyz.wonyeong.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.wonyeong.api.dto.CreateToDoRequestDto;
import xyz.wonyeong.api.dto.ToDo;
import xyz.wonyeong.api.dto.UpdateToDoRequestDto;
import xyz.wonyeong.api.repository.ToDoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDo create(CreateToDoRequestDto createToDoRequestDto) {
        return toDoRepository.save(ToDo.from(createToDoRequestDto));
    }

    public List<ToDo> getAll() {
        return toDoRepository.findAll();
    }

    public ToDo changeCompletedStatus(UpdateToDoRequestDto updateToDoRequestDto) {
        ToDo todo = getTodo(updateToDoRequestDto);
        todo.setCompleted(updateToDoRequestDto.getCompleted());

        return toDoRepository.save(todo);
    }

    private ToDo getTodo(UpdateToDoRequestDto updateToDoRequestDto) {
        return toDoRepository.findById(updateToDoRequestDto.getId())
                .orElseThrow(() -> new IllegalStateException(updateToDoRequestDto.getId() + " id를 가진 todo가 존재하지 않습니다."));
    }

    public void delete(long todoId) {
        toDoRepository.deleteById(todoId);
    }
}
