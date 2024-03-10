package wonow.elasticsearchpractice.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public void createPost(CreatingPostReq request) {

        postRepository.save(new Post(request));
    }
}
