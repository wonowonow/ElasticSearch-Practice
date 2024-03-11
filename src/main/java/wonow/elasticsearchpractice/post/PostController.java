package wonow.elasticsearchpractice.post;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public void createPost(
            @RequestBody CreatingPostReq request
    ) {

        postService.createPost(request);
    }

    @GetMapping("/post")
    public ResponseEntity<List<ReadPostListRes>> searchPostList(
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "title") String criteria,
            @RequestParam(required = false) String title
    ) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Direction.DESC, criteria));

        List<ReadPostListRes> response = postService.searchPostList(title, pageable);

        return ResponseEntity.ok(response);
    }
}
