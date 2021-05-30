package ru.itis.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springbootdemo.models.Paper;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaperDto {
    private Long id;
    private String title;
    private String description;
    private Long authorId;

    public static PaperDto from(Paper paper) {
        return PaperDto.builder()
                .id(paper.getId())
                .title(paper.getTitle())
                .description(paper.getDescription())
                .authorId(paper.getUser().getId())
                .build();
    }

    public static List<PaperDto> from(List<Paper> papers) {
        return papers.stream().map(PaperDto::from).collect(Collectors.toList());
    }
}
