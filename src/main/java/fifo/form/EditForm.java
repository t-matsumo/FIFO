package fifo.form;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import fifo.entity.User;
import fifo.repository.UserRepository;

public class EditForm {
  @Autowired
  UserRepository userRepository;

  @NotNull
  private String name;

  @NotNull
  private String userId;

  @NotNull
  private String oldpassword;

  private String newpassword;

  public Boolean hasDifferentUserId(User user) {
    return user.hasDifferentUserId(userId);
  }

  public Boolean hasInvalidUserId() {
    // ユーザIDが使われている→無効なユーザID
    return (userRepository.findByUserId(userId) != null);
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUserId() {
    return this.userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getOldpassword() {
    return this.oldpassword;
  }

  public void setOldpassword(String oldpassword) {
    this.oldpassword = oldpassword;
  }

  public String getNewpassword() {
    return this.newpassword;
  }

  public void setNewpassword(String newpassword) {
    this.newpassword = newpassword;
  }
}