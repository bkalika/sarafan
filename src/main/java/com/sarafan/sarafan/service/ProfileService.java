package com.sarafan.sarafan.service;

import com.sarafan.sarafan.domain.User;
import com.sarafan.sarafan.domain.UserSubscription;
import com.sarafan.sarafan.repo.UserDetailsRepo;
import com.sarafan.sarafan.repo.UserSubscriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author @bkalika
 * Created on 16.08.2022 8:33 PM
 */

@Service
public class ProfileService {
    private final UserDetailsRepo userDetailsRepo;
    private final UserSubscriptionRepo userSubscriptionRepo;

    @Autowired
    public ProfileService(
            UserDetailsRepo userDetailsRepo,
            UserSubscriptionRepo userSubscriptionRepo
    ) {
        this.userDetailsRepo = userDetailsRepo;
        this.userSubscriptionRepo = userSubscriptionRepo;
    }

    public User changeSubscription(User channel, User subscriber) {
        List<UserSubscription> subscriptions = channel.getSubscribers()
                .stream()
                .filter(subscription ->
                        subscription.getSubscriber().equals(subscriber)
                ).toList();

        if(!subscriptions.isEmpty()) {
            subscriptions.forEach(channel.getSubscribers()::remove);
        }
        return userDetailsRepo.save(channel);
    }

    public List<UserSubscription> getSubscribers(User channel) {
        return userSubscriptionRepo.findByChannel(channel);
    }

    public UserSubscription changeSubscriptionStatus(User channel, User subscriber) {
        UserSubscription subscription = userSubscriptionRepo.findByChannelAndSubscriber(channel, subscriber);
        subscription.setActive(!subscription.isActive());

        return userSubscriptionRepo.save(subscription);
    }
}
