package com.hendisantika.oauth2.authorizationserver.repository;

import com.hendisantika.oauth2.authorizationserver.domain.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : authorization-server
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-19
 * Time: 06:47
 */
public interface CredentialRepository extends JpaRepository<Credentials, Long> {
    Credentials findByName(String name);
}