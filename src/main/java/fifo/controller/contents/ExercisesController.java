package fifo.controller.contents;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/exercises")
public class ExercisesController {
  @RequestMapping(method = RequestMethod.GET)
  public String index() {
    return "contents/exercises/index";
  }
}