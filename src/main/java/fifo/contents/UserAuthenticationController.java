package fifo.contents;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/auth")
public class UserAuthenticationController {
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String index() {
    return "root/index";
  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String index2() {
    return "root/index";
  }
}