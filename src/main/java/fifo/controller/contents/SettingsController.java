package fifo.controller.contents;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/settings")
public class SettingsController {
  @RequestMapping(method = RequestMethod.GET)
  public String index() {
    return "contents/settings/index";
  }
}