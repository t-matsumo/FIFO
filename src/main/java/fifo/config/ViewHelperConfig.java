package fifo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fifo.viewHelper.ViewHelper;

@Configuration
public class ViewHelperConfig {
  @Bean
  public ViewHelper viewHelper() {
    return new ViewHelper();
  }
}