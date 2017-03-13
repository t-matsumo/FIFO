package fifo.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping(value = "/users/{userId}/archives")
public class ArchivesController {
  @RequestMapping(method = RequestMethod.GET)
  public String index(@PathVariable("userId") String userId) {
    return "user/archives/index";
  }
}