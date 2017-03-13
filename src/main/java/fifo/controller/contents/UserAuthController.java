package fifo.controller.contents;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/auth")
public class UserAuthController {
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login() {
    return "contents/userAuth/index";
  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logout() {
    return "contents/userAuth/index";
  }
}