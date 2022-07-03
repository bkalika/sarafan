package com.sarafan.sarafan.repo;

import com.sarafan.sarafan.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author @bkalika
 * Created on 17.06.2022 2:12 PM
 */
@Repository
public interface UserDetailsRepo extends JpaRepository<User, String> {
}
