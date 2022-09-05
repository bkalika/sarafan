package com.sarafan.sarafan.domain;

import com.fasterxml.jackson.annotation.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author @bkalika
 * Created on 17.06.2022 2:10 PM
 */
@Entity
@Table(name="usr")
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "name"})
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = -7531630416626822131L;

	@Id
    @JsonView(Views.IdName.class)
    private String id;
    
    @JsonView(Views.IdName.class)
    private String name;
    
    @JsonView(Views.IdName.class)
    private String userpic;
    
    private String email;
    @JsonView(Views.FullProfile.class)
    private String gender;
    @JsonView(Views.FullProfile.class)
    private String locale;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView(Views.FullProfile.class)
    private LocalDateTime lastVisit;

//    @ManyToMany
//    @JoinTable(
//            name = "user_subscriptions",
//            joinColumns = @JoinColumn(name = "subscriber_id"),
//            inverseJoinColumns = @JoinColumn(name = "channel_id")
//    )
//    @JsonIdentityReference
//    @JsonIdentityInfo(
//            property = "id",
//            generator = ObjectIdGenerators.PropertyGenerator.class
//    )
    @JsonView(Views.FullProfile.class)
    @OneToMany(
            mappedBy = "subscriber",
            orphanRemoval = true
    )
    private Set<UserSubscription> subscriptions = new HashSet<>();

//    @ManyToMany
//    @JoinTable(
//            name = "user_subscriptions",
//            joinColumns = @JoinColumn(name = "channel_id"),
//            inverseJoinColumns = @JoinColumn(name = "subscriber_id")
//    )
//    @JsonIdentityReference
//    @JsonIdentityInfo(
//            property = "id",
//            generator = ObjectIdGenerators.PropertyGenerator.class
//    )
    @OneToMany(
            mappedBy = "channel",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    @JsonView(Views.FullProfile.class)
    private Set<UserSubscription> subscribers = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public LocalDateTime getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(LocalDateTime lastVisit) {
        this.lastVisit = lastVisit;
    }

    public Set<UserSubscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<UserSubscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Set<UserSubscription> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<UserSubscription> subscribers) {
        this.subscribers = subscribers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
