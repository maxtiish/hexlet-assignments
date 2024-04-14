package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping()
    public List<Post> index() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post show(@PathVariable long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        return post;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        postRepository.save(post);
        return post;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post update(@RequestBody Post post, @PathVariable long id) {
        var newPost = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        newPost.setBody(post.getBody());
        newPost.setTitle(post.getTitle());

        postRepository.save(newPost);

        return newPost;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        if (postRepository.findById(id).isPresent()) {
            commentRepository.deleteByPostId(id);
            postRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Post with id" + id + " not found");
        }
    }
}
// END
