package com.hackdead.wheelmanager.maps.mapper;

import com.hackdead.wheelmanager.core.entities.Subscription;
import com.hackdead.wheelmanager.maps.request.SubscriptionRequest;

public class SubscriptionMapper {
    public static Subscription toSubscription(SubscriptionRequest subscriptionRequest) {
        Subscription subscription = new Subscription();
        subscription.setSubscriptionPrice(subscriptionRequest.getSubscriptionPrice());
        subscription.setDescription(subscriptionRequest.getDescription());
        subscription.setStartDate(subscriptionRequest.getStartDate());
        return subscription;
    }
}
