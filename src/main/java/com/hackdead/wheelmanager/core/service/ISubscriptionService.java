package com.hackdead.wheelmanager.core.service;

import com.hackdead.wheelmanager.core.entities.Subscription;

import java.util.Date;
import java.util.List;

public interface ISubscriptionService extends CrudService<Subscription> {
    List<Subscription> findSubscriptionByStartDate(Date startDate);
}