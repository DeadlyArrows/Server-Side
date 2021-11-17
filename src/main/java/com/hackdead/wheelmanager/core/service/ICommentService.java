package com.hackdead.wheelmanager.core.service;

import com.hackdead.wheelmanager.core.entities.Comment;

import java.util.Date;
import java.util.List;

public interface ICommentService extends CrudService<Comment> {
    List<Comment> findCommentByPublicationDate(Date publicationDate);
}
