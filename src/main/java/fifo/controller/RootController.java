package fifo.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fifo.entity.User;

@Controller
@RequestMapping(value = "/")
public class RootController {
  @RequestMapping(method = RequestMethod.GET)
  public String index(Principal principal, Model model) {
    if (isLogined(principal)) {
      Authentication auth = (Authentication)principal;
      User loginUser = (User)auth.getPrincipal();
      
      model.addAttribute("deadlines", loginUser.getDeadlines());
    }

    return "root/index";
  }

  private boolean isLogined(Principal principal) {
    return (principal != null);
  }
}