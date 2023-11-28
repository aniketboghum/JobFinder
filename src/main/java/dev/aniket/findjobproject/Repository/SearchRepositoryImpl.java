package dev.aniket.findjobproject.Repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dev.aniket.findjobproject.model.Post;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository{

    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoConverter mongoConverter;

    @Override
    public List<Post> findByQueryText(String queryText) {
        List<Post> postList = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("JobListing");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                                                    new Document("index", "default")
                                                    .append("text",
                                                    new Document("query", queryText)
                                                    .append("path", Arrays.asList("desc", "techs")))),
                                                    new Document("$sort",
                                                    new Document("field1", 1L))));

        result.forEach(document -> postList.add(mongoConverter.read(Post.class, document)));
        return postList;
    }
}
