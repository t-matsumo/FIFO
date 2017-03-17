package fifo.controller.contents;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/archives")
public class ArchivesController {
  @RequestMapping(method = RequestMethod.GET)
  public String index() {
    return "contents/archives/index";
  }
}