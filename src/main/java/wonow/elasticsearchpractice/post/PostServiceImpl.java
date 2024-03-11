package wonow.elasticsearchpractice.post;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostElasticSearchRepository postElasticSearchRepository;

    @Override
    @Transactional
    public void createPost(
            CreatingPostReq request
    ) {

        Post post = new Post(request);
        postRepository.save(post);
    }

    @Override
    public List<ReadPostListRes> searchPostList(
            String title,
            Pageable pageable
    ) {

        return postElasticSearchRepository.findByTitleContains(title, pageable).stream().map(
                post -> new ReadPostListRes(post.getTitle(), post.getContent())
        )
                .collect(Collectors.toList());
    }
}
