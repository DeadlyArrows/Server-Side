package com.hackdead.wheelmanager.service;

import com.hackdead.wheelmanager.core.entities.Comment;
import com.hackdead.wheelmanager.core.entities.Customer;
import com.hackdead.wheelmanager.core.entities.Vehicle;
import com.hackdead.wheelmanager.core.repository.ICommentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {
    @Mock
    private ICommentRepository commentRepository;
    @InjectMocks
    private CommentServiceImpl commentService;

    @Test
    void save() {
        Comment comment = new Comment(1L, "first comment",
                new Date(2010, 10, 30),
                new Customer(), new Vehicle());

        given(commentRepository.save(comment)).willReturn(comment);

        Comment savedComment = null;
        try {
            savedComment = commentService.save(comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(savedComment).isNotNull();
        verify(commentRepository).save(any(Comment.class));
    }

    @Test
    void delete() throws Exception {
        Long id = 1L;
        commentService.delete(id);
        verify(commentRepository, times(1)).deleteById(id);
    }

    @Test
    void getAll() throws Exception {
        List<Comment> commentList = new ArrayList<>();
        commentList.add(new Comment(1L, "first comment",
                new Date(2010, 10, 30),
                new Customer(), new Vehicle()));
        commentList.add(new Comment(2L, "first comment",
                new Date(2010, 10, 30),
                new Customer(), new Vehicle()));
        commentList.add(new Comment(3L, "first comment",
                new Date(2010, 10, 30),
                new Customer(), new Vehicle()));

        given(commentRepository.findAll()).willReturn(commentList);

        List<Comment> expected = commentService.getAll();
        assertEquals(expected, commentList);
    }

    @Test
    void getById() throws Exception {
        Long id = 1L;
        Comment comment = new Comment(1L, "first comment",
                new Date(2010, 10, 30),
                new Customer(), new Vehicle());
        given(commentRepository.findById(id)).willReturn(Optional.of(comment));

        Optional<Comment> expected = commentService.getById(id);
        assertThat(expected).isNotNull();
    }

    @Test
    void findCommentByPublicationDate() {
        Date date = new Date(2010, 10, 30);
        Comment comment = new Comment(1L, "first comment",
                date,
                new Customer(), new Vehicle());
        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);

        given(commentRepository.findAllWithPublicationDate(date))
                .willReturn(commentList);

        List<Comment> expected = commentService.findCommentByPublicationDate(date);

        assertThat(commentList).isEqualTo(expected);
    }
}