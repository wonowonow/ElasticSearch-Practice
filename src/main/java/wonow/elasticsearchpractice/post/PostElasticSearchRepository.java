package wonow.elasticsearchpractice.post;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PostElasticSearchRepository extends ElasticsearchRepository<Post, Long> {

    List<Post> findByTitleContains(String title, Pageable pageable);

}
