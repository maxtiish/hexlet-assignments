package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/{id}")
    public PostDTO show(@PathVariable long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));

        return getPostDTO(post);
    }

    @GetMapping()
    public List<PostDTO> index() {
        var users = postRepository.findAll();
        var result = users.stream()
                .map(this::getPostDTO)
                .toList();
        return result;
    }

    private List<CommentDTO> getCommentsDTO(Post post) {
        var comments = commentRepository.findByPostId(post.getId());
        List<CommentDTO> result = new ArrayList<>();
        for (var comm : comments) {
            var dto = new CommentDTO();
            dto.setId(comm.getId());
            dto.setBody(comm.getBody());
            result.add(dto);
        }
        return result;
    }

    private PostDTO getPostDTO(Post post) {
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());

        var comments = getCommentsDTO(post);
        dto.setComments(comments);
        return dto;
    }
}
// END
