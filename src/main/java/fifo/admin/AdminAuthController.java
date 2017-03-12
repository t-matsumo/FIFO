package fifo.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminAuthController {
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login() {
    return "admin/index";
  }
}