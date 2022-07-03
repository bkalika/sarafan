package com.sarafan.sarafan.repo;

import com.sarafan.sarafan.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author @bkalika
 * Created on 16.06.2022 8:53 PM
 */
public interface MessageRepo extends JpaRepository<Message, Long> {

}
