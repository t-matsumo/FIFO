package fifo.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import fifo.form.RegisterForm;
import fifo.entity.User;
import fifo.repository.UserRepository;

@Controller
@RequestMapping(value = "/users")
public class UsersController {
  @Autowired
  UserRepository userRepository;

  @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
  public String index(@PathVariable("userId") String userId) {
    return "user/users/index";
  }

  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public String showRegisterForm(RegisterForm registerForm) {
    return "user/users/registerForm";
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String register(@Valid RegisterForm registerForm, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "user/users/registerForm";
    }
    
    userRepository.save(new User(registerForm.getName(), registerForm.getUserId(), registerForm.getPassword()));
    
    return "redirect:/";
  }
}