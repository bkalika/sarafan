package com.sarafan.sarafan.repo;

import com.sarafan.sarafan.domain.User;
import com.sarafan.sarafan.domain.UserSubscription;
import com.sarafan.sarafan.domain.UserSubscriptionId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author @bkalika
 * Created on 16.08.2022 10:56 PM
 */
public interface UserSubscriptionRepo extends JpaRepository<UserSubscription, UserSubscriptionId> {
    List<UserSubscription> findBySubscriber(User user);
    List<UserSubscription> findByChannel(User channel);
    UserSubscription findByChannelAndSubscriber(User channel, User subscriber);
}
