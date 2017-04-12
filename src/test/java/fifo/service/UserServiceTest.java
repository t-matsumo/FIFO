package fifo.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import fifo.entity.User;
import fifo.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
  @Autowired
  private UserService userService;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  private String name     = "testUser";
  private String userId   = "userId";
  private String password = "password";

  @Before
  public void before() throws Exception {
    String encodedPassword = passwordEncoder.encode(password);
    User user = new User(name, userId, encodedPassword);
    userRepository.save(user);
  }

  @Test
  public void testLoadUserByUsername() throws Exception {
    User user = (User)userService.loadUserByUsername(this.userId);
    Assert.assertEquals(this.name, user.getUsername());
    Assert.assertEquals(this.userId, user.getUserId());
    Assert.assertTrue(passwordEncoder.matches(this.password, user.getPassword()));
  }

  @After
  public void after() throws Exception {
    User user = userRepository.findByUserId(this.userId);
    userRepository.delete(user);
  }
}