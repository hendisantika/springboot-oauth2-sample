package com.hendisantika.oauth2.authorizationserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Controller;

/**
 * Created by IntelliJ IDEA.
 * Project : authorization-server
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-20
 * Time: 05:54
 */
@Controller
public class LoginController {
    @Autowired
    private JdbcClientDetailsService clientDetailsService;
}
