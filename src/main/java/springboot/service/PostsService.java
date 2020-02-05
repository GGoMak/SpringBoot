package springboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.domain.posts.Posts;
import springboot.domain.posts.PostsRepository;
import springboot.web.dto.Pagination;
import springboot.web.dto.PostsListResponseDto;
import springboot.web.dto.PostsResponseDto;
import springboot.web.dto.PostsSaveRequestDto;
import springboot.web.dto.PostsUpdateRequestDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        postsRepository.delete(posts);
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<PostsListResponseDto> selectBoardList(Pagination page) {
        return postsRepository.selectBoardList(page.getPageStart(), page.getPerPageNum()).stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<PostsListResponseDto> findListDesc(Pagination page){

        if(page.getSearchType().equals("title")){
            return postsRepository.findTitleDesc(page.getPageStart(), page.getPerPageNum(), page.getKeyword()).stream()
                    .map(PostsListResponseDto::new)
                    .collect(Collectors.toList());
        }
        else if(page.getSearchType().equals("content")){
            return postsRepository.findContentDesc(page.getPageStart(), page.getPerPageNum(), page.getKeyword()).stream()
                    .map(PostsListResponseDto::new)
                    .collect(Collectors.toList());
        }
        else if(page.getSearchType().equals("author")){
            return postsRepository.findAuthorDesc(page.getPageStart(), page.getPerPageNum(), page.getKeyword()).stream()
                    .map(PostsListResponseDto::new)
                    .collect(Collectors.toList());
        }
        else {
            return postsRepository.findListDesc(page.getPageStart(), page.getPerPageNum(), page.getKeyword()).stream()
                    .map(PostsListResponseDto::new)
                    .collect(Collectors.toList());
        }
    }

    @Transactional
    public int getTotalCnt(Pagination page) {

        if(page.getSearchType().equals("title")){
            return postsRepository.getTitleTotalCnt(page.getKeyword());
        }
        else if(page.getSearchType().equals("content")){
            return postsRepository.getContentTotalCnt(page.getKeyword());
        }
        else if(page.getSearchType().equals("author")){
            return postsRepository.getAuthorTotalCnt(page.getKeyword());
        }
        else{
            return postsRepository.getTitleTotalCnt(page.getKeyword());
        }
    }

}
