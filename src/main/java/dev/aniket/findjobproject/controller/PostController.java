package dev.aniket.findjobproject.controller;

import dev.aniket.findjobproject.Repository.PostRepository;
import dev.aniket.findjobproject.Repository.SearchRepository;
import dev.aniket.findjobproject.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PostController
{
    @Autowired
    PostRepository postRepository;

    @Autowired
    SearchRepository searchRepository;

    @GetMapping("/all-posts")
    public List<Post> GetAllJobPost()
    {
        return postRepository.findAll();
    }

    @GetMapping("/all-posts/{queryText}")
    public List<Post> search(@PathVariable String queryText)
    {
        return searchRepository.findByQueryText(queryText);
    }

    @PostMapping("/create-new-post")
    public Post CreatePost(@RequestBody Post post)
    {
        return postRepository.insert(post);
    }
}
