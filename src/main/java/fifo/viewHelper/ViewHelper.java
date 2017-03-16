package fifo.viewHelper;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

public class ViewHelper {
  @Autowired
  private HttpServletRequest httpServletRequest;

  public String getNavBarItemStatus(String servletPath) {
    if (httpServletRequest.getServletPath().equals(servletPath)) {
      return "active";
    }

    return "";
  }

  public Boolean isAuthenticated() {
    return (httpServletRequest.getRemoteUser() != null);
  }
}