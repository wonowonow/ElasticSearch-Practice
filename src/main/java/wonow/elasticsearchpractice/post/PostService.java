package wonow.elasticsearchpractice.post;

import java.util.List;
import org.springframework.data.domain.Pageable;

public interface PostService {

    void createPost(CreatingPostReq request);

    List<ReadPostListRes> searchPostList(String title, Pageable pageable);
}