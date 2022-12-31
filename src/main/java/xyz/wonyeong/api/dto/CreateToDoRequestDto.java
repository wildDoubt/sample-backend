package xyz.wonyeong.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateToDoRequestDto {
    private String title;
    private String contents;
}
