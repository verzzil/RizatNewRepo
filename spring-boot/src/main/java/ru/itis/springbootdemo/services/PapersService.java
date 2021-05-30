package ru.itis.springbootdemo.services;

import ru.itis.springbootdemo.dto.PageablePaperDto;
import ru.itis.springbootdemo.dto.PaperDto;
import ru.itis.springbootdemo.dto.PapersPage;
import ru.itis.springbootdemo.models.Paper;

import java.util.List;

public interface PapersService {
    PapersPage search(Integer size, Integer page, String query, String sort, String direction);

    List<PaperDto> findAllPapers();

    void save(PaperDto paperDto);

    void deleteById(Long paperId);

    void editPaper(PaperDto paperDto);

    List<PaperDto> findPapersByTemplate(String template);

    List<PaperDto> findPapersFromUserId(Long userId);

    PageablePaperDto getPageablePapers(Integer pageId);
}
