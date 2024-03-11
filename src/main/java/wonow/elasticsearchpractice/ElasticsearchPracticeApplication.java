package wonow.elasticsearchpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import wonow.elasticsearchpractice.post.PostElasticSearchRepository;

@EnableJpaRepositories(excludeFilters = @ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE,
        classes = PostElasticSearchRepository.class
))
@SpringBootApplication
public class ElasticsearchPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchPracticeApplication.class, args);
    }

}
