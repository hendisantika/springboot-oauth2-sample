package com.hendisantika.oauth2.authorizationserver.controller;

import com.hendisantika.oauth2.authorizationserver.config.AuthorityPropertyEditor;
import com.hendisantika.oauth2.authorizationserver.config.SplitCollectionEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : authorization-server
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-20
 * Time: 05:57
 */
@Controller
@RequestMapping("clients")
public class ClientsController {
    @Autowired
    private JdbcClientDetailsService clientsDetailsService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(Collection.class, new SplitCollectionEditor(Set.class, ","));
        binder.registerCustomEditor(GrantedAuthority.class, new AuthorityPropertyEditor());

    }

    @GetMapping("/form")
    @PreAuthorize("hasRole('ROLE_OAUTH_ADMIN')")
    public String showEditForm(@RequestParam(value = "client", required = false) String clientId, Model model) {

        ClientDetails clientDetails;
        if (clientId != null) {
            clientDetails = clientsDetailsService.loadClientByClientId(clientId);
        } else {
            clientDetails = new BaseClientDetails();
        }

        model.addAttribute("clientDetails", clientDetails);
        return "form";
    }
}
