package dev.aniket.findjobproject.Repository;

import dev.aniket.findjobproject.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String>
{

}
