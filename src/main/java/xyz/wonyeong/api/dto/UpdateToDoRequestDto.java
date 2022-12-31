package xyz.wonyeong.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateToDoRequestDto {
    private Long id;
    private Boolean completed;
}
