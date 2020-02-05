package springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query(nativeQuery = true, value = "select * from Posts p order by p.id")
    List<Posts> findAllDesc();

    // Pagination
    @Query(nativeQuery = true, value = "select * from Posts order by id desc limit :pageStart, :perPageNum")
    List<Posts> selectBoardList(int pageStart, int perPageNum);

    // 검색 쿼리
    @Query(value = "SELECT * FROM Posts WHERE title LIKE CONCAT('%', :keyword, '%') ORDER BY id DESC LIMIT :pageStart, :perPageNum", nativeQuery = true)
    List<Posts> findListDesc(int pageStart, int perPageNum, String keyword);

    @Query(value = "SELECT * FROM Posts WHERE title LIKE CONCAT('%', :keyword, '%') ORDER BY id DESC LIMIT :pageStart, :perPageNum", nativeQuery = true)
    List<Posts> findTitleDesc(int pageStart, int perPageNum, String keyword);

    @Query(value = "SELECT * FROM Posts WHERE content LIKE CONCAT('%', :keyword, '%') ORDER BY id DESC LIMIT :pageStart, :perPageNum", nativeQuery = true)
    List<Posts> findContentDesc(int pageStart, int perPageNum, String keyword);

    @Query(value = "SELECT * FROM Posts WHERE author LIKE CONCAT('%', :keyword, '%') ORDER BY id DESC LIMIT :pageStart, :perPageNum", nativeQuery = true)
    List<Posts> findAuthorDesc(int pageStart, int perPageNum, String keyword);

    @Query(value = "SELECT COUNT(*) FROM Posts WHERE title LIKE CONCAT('%',:keyword,'%')", nativeQuery = true)
    int getTitleTotalCnt(String keyword);

    @Query(value = "SELECT COUNT(*) FROM Posts WHERE content LIKE CONCAT('%',:keyword,'%')", nativeQuery = true)
    int getContentTotalCnt(String keyword);

    @Query(value = "SELECT COUNT(*) FROM Posts WHERE author LIKE CONCAT('%',:keyword,'%')", nativeQuery = true)
    int getAuthorTotalCnt(String keyword);
}
