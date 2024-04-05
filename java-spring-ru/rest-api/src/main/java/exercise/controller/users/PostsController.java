package exercise.controller.users;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("api")
public class PostsController {
    List<Post> posts = Data.getPosts();
    @GetMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> index(@PathVariable int id) {
        return posts.stream()
                .filter(u -> u.getUserId() == id)
                .toList();
    }

    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create( @RequestBody Post post, @PathVariable int id) {
        var newpost = new Post();
        newpost.setUserId(id);
        newpost.setTitle(post.getTitle());
        newpost.setSlug(post.getSlug());
        newpost.setBody(post.getBody());
        posts.add(newpost);

        return newpost;
    }
}
// END
