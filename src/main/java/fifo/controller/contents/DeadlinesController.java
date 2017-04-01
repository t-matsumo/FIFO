package fifo.controller.contents;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fifo.entity.Deadline;
import fifo.entity.User;
import fifo.form.DeadlineForm;
import fifo.repository.UserRepository;

@Controller
@RequestMapping(value = "/deadlines")
class DeadlinesController {
  @Autowired
  private UserRepository userRepository;

  @RequestMapping(method = RequestMethod.GET)
  public String index(Principal principal, Model model) {
    Authentication auth = (Authentication)principal;
    User loginUser = (User)auth.getPrincipal();

    model.addAttribute("deadlines", loginUser.getDeadlines());

    return "contents/deadlines/index";
  }

  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public String showForm(DeadlineForm deadlineForm) {
    return "/contents/deadlines/register";
  }
  
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String setDeadline(Principal principal, @Valid DeadlineForm deadlineForm, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "/contents/deadlines/register";
    }

    Authentication auth = (Authentication)principal;
    User loginUser = (User)auth.getPrincipal();

    String task  = deadlineForm.getTask();
    int    year  = deadlineForm.getYear();
    int    month = deadlineForm.getMonth();
    int    day   = deadlineForm.getDay();
    loginUser.addDeadline(new Deadline(task, year, month, day));
    userRepository.save(loginUser);

    return "redirect:/";
  }
}