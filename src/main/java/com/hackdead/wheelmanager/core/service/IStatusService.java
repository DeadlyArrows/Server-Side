package com.hackdead.wheelmanager.core.service;

import com.hackdead.wheelmanager.core.entities.Status;

import java.util.List;

public interface IStatusService extends CrudService<Status> {
    List<Status> findByStatusName(String statusName) throws Exception;
}
