package fifo.contents.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping(value = "/users")
public class UsersController {
  @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
  public String index(@PathVariable("userId") String userId) {
    return "contents/user/users/index";
  }

  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public String index2() {
    return "contents/user/users/index";
  }
}