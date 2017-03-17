package fifo.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RegisterForm {
  @NotNull
  private String name;

  @NotNull
  private String userId;

  @NotNull
  private String password;

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

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}