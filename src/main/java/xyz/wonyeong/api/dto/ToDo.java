package xyz.wonyeong.api.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "todo")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String contents;
    @Column
    private Boolean completed;

    @Builder
    public ToDo(Long id, String title, String contents, Boolean completed) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.completed = completed;
    }

    public static ToDo from(CreateToDoRequestDto createToDoRequestDto) {
        return ToDo.builder()
                .title(createToDoRequestDto.getTitle())
                .contents(createToDoRequestDto.getContents())
                .completed(false)
                .build();
    }
}
