package wonow.elasticsearchpractice.post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document(indexName = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Field(type = FieldType.Text, name = "title")
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    @Field(type = FieldType.Text, name = "content")
    private String content;

    public Post(CreatingPostReq request) {
        this.title = request.title();
        this.content = request.content();
    }
}
