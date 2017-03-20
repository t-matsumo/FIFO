package fifo.controller.contents;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fifo.form.RegisterForm;
import fifo.form.EditForm;
import fifo.entity.User;
import fifo.repository.UserRepository;

@Controller
@RequestMapping(value = "/users")
public class UsersController {
  @Autowired
  UserRepository userRepository;

  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public String showRegisterForm(RegisterForm registerForm) {
    return "contents/users/registerForm";
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String register(@Valid RegisterForm registerForm, BindingResult bindingResult) {
    if (isUsedUserId(registerForm.getUserId())) {
      bindingResult.addError(new FieldError("registerForm", "userId", "他のユーザIDにしてください．"));
    }

    if (bindingResult.hasErrors()) {
      return "contents/users/registerForm";
    }
    
    userRepository.save(registerForm.createUser());
    
    return "redirect:/";
  }

  @RequestMapping(value = "/profile", method = RequestMethod.GET)
  public String profile(Principal principal, Model model) {
    Authentication auth = (Authentication)principal;
    User loginUser = (User)auth.getPrincipal();

    model.addAttribute("loginUser", loginUser);

    return "contents/users/profile";
  }

  @RequestMapping(value = "/edit", method = RequestMethod.GET)
  public String editForm(EditForm editForm) {
    return "contents/users/edit";
  }

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public String edit(Principal principal, @Valid EditForm editForm, BindingResult bindingResult) {
    Authentication auth = (Authentication)principal;
    User loginUser = (User)auth.getPrincipal();

    if (editForm.hasDifferentUserId(loginUser) && isUsedUserId(editForm.getUserId())) {
      bindingResult.addError(new FieldError("editForm", "userId", "他のユーザIDにしてください．"));
    }

    if (bindingResult.hasErrors()) {
      return "contents/users/edit";
    }
    
    loginUser.update(editForm.createUser());
    userRepository.save(loginUser);

    return "redirect:/users/profile";
  }

  private Boolean isUsedUserId(String userId) {
    return (userRepository.findByUserId(userId) != null);
  }
}