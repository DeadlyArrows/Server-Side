package com.hackdead.wheelmanager.maps.mapper;

import com.hackdead.wheelmanager.core.entities.Comment;
import com.hackdead.wheelmanager.maps.request.CommentRequest;

public class CommentMapper {
    public static Comment toComment(CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setContent(commentRequest.getContent());
        comment.setPublicationDate(commentRequest.getPublicationDate());
        return comment;
    }
}
