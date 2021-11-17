package com.hackdead.wheelmanager.controller;

import com.hackdead.wheelmanager.core.entities.Comment;
import com.hackdead.wheelmanager.core.service.ICommentService;
import com.hackdead.wheelmanager.maps.mapper.CommentMapper;
import com.hackdead.wheelmanager.maps.request.CommentRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
@RestController
@RequestMapping("/api/comments")
@Api(tags = "Comments", value = "Service Web RESTFul of comments")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    public static Date parseDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date result = null;
        try {
            result = format.parse(date);
        } catch (Exception ignored) {
        }
        return result;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "List Comments", notes = "Method to list all Comments")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Comments found"),
            @ApiResponse(code = 404, message = "Comments not found")
    })
    public ResponseEntity<List<Comment>> findAll() {
        try {
            List<Comment> comments = commentService.getAll();
            if (comments.isEmpty())
                return new ResponseEntity<>(comments, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search Comment by Id", notes = "Method to find a Comment by Id")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Comment found"),
            @ApiResponse(code = 404, message = "Comment not found")
    })
    public ResponseEntity<Comment> findById(@PathVariable("id") Long id) {
        try {
            Optional<Comment> comment = commentService.getById(id);
            return comment.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/searchCommentByPublicationDate", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search a Comment by publication date", notes = "Method to find Comment by publication date")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Comments found"),
            @ApiResponse(code = 404, message = "Comments not found"),
    })
    public ResponseEntity<List<Comment>> findByCommentByPublicationDate(@RequestParam(name = "publicationDate") String publicationDate) {
        try {
            Date publicationDateNew = parseDate(publicationDate);
            List<Comment> comments = commentService.findCommentByPublicationDate(publicationDateNew);
            if (!comments.isEmpty())
                return new ResponseEntity<>(comments, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Registration of Comment", notes = "Method to register Comment in the BD")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Comment found"),
            @ApiResponse(code = 404, message = "Comment not found")
    })
    public ResponseEntity<Comment> insertComment(@Valid @RequestBody CommentRequest commentRequest) {
        try {
            Comment commentNew = commentService.save(CommentMapper.toComment(commentRequest));
            return ResponseEntity.status(HttpStatus.CREATED).body(commentNew);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update Comments data", notes = "Method to update Comments")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Comment updated"),
            @ApiResponse(code = 404, message = "Comment not updated")
    })
    public ResponseEntity<Comment> updateComment(
            @PathVariable("id") Long id, @Valid @RequestBody CommentRequest commentRequest) {
        try {
            Optional<Comment> commentUp = commentService.getById(id);
            if (!commentUp.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            Comment commentUpdate = CommentMapper.toComment(commentRequest);
            commentUpdate.setId(id);
            commentService.save(commentUpdate);
            return new ResponseEntity<>(commentUpdate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete Comment", notes = "Method to delete Comment")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Comment deleted"),
            @ApiResponse(code = 404, message = "Comment not deleted")
    })
    public ResponseEntity<Comment> deleteComment(@PathVariable("id") Long id) {
        try {
            Optional<Comment> deleteComment = commentService.getById(id);
            if (!deleteComment.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            commentService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
