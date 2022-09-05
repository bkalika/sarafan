package com.sarafan.sarafan.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sarafan.sarafan.domain.User;
import com.sarafan.sarafan.domain.UserSubscription;
import com.sarafan.sarafan.domain.Views;
import com.sarafan.sarafan.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;

/**
 * @author @bkalika
 * Created on 16.08.2022 8:33 PM
 */

@RestController
@RequestMapping("profile")
public class ProfileController {
    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("{id}")
    @JsonView(Views.FullProfile.class)
    public User get(@PathVariable("id") User user) {
        return user;
    }

    @PostMapping("change-subscription/{channelId}")
    @JsonView(Views.FullProfile.class)
    public User changeSubscription(
//            @AuthenticationPrincipal User subscriber,
            User subscriber,
            @PathVariable("channelId") User channel
    ) {
        if(subscriber.equals(channel)) {
            return channel;
        } else {
            return profileService.changeSubscription(channel, subscriber);
        }
    }

    @GetMapping("subscribers/{channelId}")
    @JsonView(Views.IdName.class)
    public List<UserSubscription> subscribers(
            @PathVariable("channelId") User channel) {
        return profileService.getSubscribers(channel);
    }

    @PostMapping("change-status/{subscriberId}")
    @JsonView(Views.IdName.class)
    public UserSubscription changeSubscriptionStatus(
//            @AuthenticationPrincipal User channel,
            User channel,
            @PathVariable("subscriberId") User subscriber
    ) {
        return profileService.changeSubscriptionStatus(channel, subscriber);
    }
}
