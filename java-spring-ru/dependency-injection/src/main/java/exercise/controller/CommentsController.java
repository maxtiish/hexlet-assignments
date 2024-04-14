package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;

import java.util.List;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping()
    public List<Comment> index() {
        return commentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Comment show(@PathVariable long id) {
        var comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + " not found"));
        return comment;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment create(@RequestBody Comment comment) {
        commentRepository.save(comment);
        return comment;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment update(@RequestBody Comment comment, @PathVariable long id) {
        var newComment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        newComment.setBody(comment.getBody());
        newComment.setPostId(comment.getPostId());

        commentRepository.save(newComment);
        return newComment;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        if (commentRepository.findById(id).isPresent()) {
            commentRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Not found");
        }
    }
}
// END
