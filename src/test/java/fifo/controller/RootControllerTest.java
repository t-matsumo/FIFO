package fifo.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.hamcrest.Matchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RootControllerTest {
  @Autowired
  private MockMvc mocMvc;

  @Before
  public void before() throws Exception {
  }

  @Test
  public void testIndexOk() throws Exception {
    mocMvc.perform(MockMvcRequestBuilders.get("/"))
          .andExpect(MockMvcResultMatchers.status().isOk());
          // .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Hello, PePeSe !")));
  }

  @After
  public void after() throws Exception {

  }
}