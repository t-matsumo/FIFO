package fifo.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterForm {
  @NotNull
  @Size(min = 1)
  private String name;

  @NotNull
  @Size(min = 1)
  private String userId;

  @NotNull
  @Size(min = 4)
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