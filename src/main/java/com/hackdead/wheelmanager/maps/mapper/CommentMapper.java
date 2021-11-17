package com.hackdead.wheelmanager.maps.mapper;

import com.hackdead.wheelmanager.core.entities.Comment;
import com.hackdead.wheelmanager.maps.request.CommentRequest;

public class CommentMapper {
    private CommentMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Comment toComment(CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setContent(commentRequest.getContent());
        comment.setPublicationDate(commentRequest.getPublicationDate());
        return comment;
    }
}
