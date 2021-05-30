package ru.itis.springbootdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dto.PageablePaperDto;
import ru.itis.springbootdemo.dto.PaperDto;
import ru.itis.springbootdemo.dto.PapersPage;
import ru.itis.springbootdemo.models.Paper;
import ru.itis.springbootdemo.repositories.PapersRepository;
import ru.itis.springbootdemo.repositories.UsersRepository;

import java.util.List;

import static ru.itis.springbootdemo.dto.PaperDto.from;

@Service
public class PapersServiceImpl implements PapersService {

    @Autowired
    private PapersRepository papersRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public PapersPage search(Integer size, Integer page, String query, String sortParameter, String directionParameter) {
        Direction direction = Direction.ASC;
        Sort sort = Sort.by(direction, "id");

        if (directionParameter != null) {
            direction = Direction.fromString(directionParameter);
        }

        if (sortParameter != null) {
            sort = Sort.by(direction, sortParameter);
        }

        if (query == null) {
            query = "empty";
        }

        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Paper> papersPage = papersRepository.search(query, pageRequest);

        return PapersPage.builder()
                .pagesCount(papersPage.getTotalPages())
                .papers(from(papersPage.getContent()))
                .build();
    }

    @Override
    public List<PaperDto> findAllPapers() {
        return PaperDto.from(papersRepository.findAllByOrderByIdDesc());
    }

    @Override
    public void save(PaperDto paperDto) {
        Paper paper = Paper.builder()
                .title(paperDto.getTitle())
                .description(paperDto.getDescription())
                .user(usersRepository.findById(paperDto.getAuthorId()).orElseThrow(IllegalArgumentException::new))
                .build();

        papersRepository.save(paper);
    }

    @Override
    public void deleteById(Long paperId) {
        papersRepository.deleteById(paperId);
    }

    @Override
    public void editPaper(PaperDto paperDto) {
        Paper paper = papersRepository.findById(paperDto.getId()).orElseThrow(IllegalArgumentException::new);

        if (paperDto.getTitle() != null) paper.setTitle(paperDto.getTitle());
        if (paperDto.getDescription() != null) paper.setDescription(paperDto.getDescription());

        papersRepository.save(paper);
    }

    @Override
    public List<PaperDto> findPapersByTemplate(String template) {
        return PaperDto.from(papersRepository.findAllByTitleLikeOrderByIdDesc("%" + template + "%"));
    }

    @Override
    public List<PaperDto> findPapersFromUserId(Long userId) {
        return PaperDto.from(papersRepository.findPapersFromUserId(userId));
    }

    @Override
    public PageablePaperDto getPageablePapers(Integer pageId) {
        PageRequest pageRequest = PageRequest.of(pageId - 1, 3);
        Page<Paper> papersPage = papersRepository.findAll(pageRequest);
        return PageablePaperDto.builder()
                .pageCount(papersPage.getTotalPages())
                .papers(PaperDto.from(papersPage.getContent()))
                .build();
    }
}
