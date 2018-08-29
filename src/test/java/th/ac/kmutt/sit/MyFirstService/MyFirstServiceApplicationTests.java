package th.ac.kmutt.sit.MyFirstService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import th.ac.kmutt.sit.MyFirstService.controller.User;
import th.ac.kmutt.sit.MyFirstService.controller.UserController;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyFirstServiceApplicationTests {

    @LocalServerPort
    private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
    public void userId5SelectTest(){
        assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/user?id=5", User.class).getId())
                .isEqualTo(5);
        assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/user?id=5", User.class).getName())
                .isEqualTo("test5");
    }

    @Test
    public void getAllUserTest(){
	    assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/users", User[].class).length)
                .isEqualTo(4);
        assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/users", User[].class)[0].getId())
                .isEqualTo(1);
        assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/users", User[].class)[1].getId())
                .isEqualTo(2);
        assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/users", User[].class)[2].getId())
                .isEqualTo(3);
        assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/users", User[].class)[3].getId())
                .isEqualTo(4);

    }

    @Test
    public void getUserTest(){
	    assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/user/1", User.class).getName())
                .isEqualTo("Nathawat");
        assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/user/1", User.class).getId())
                .isEqualTo(1);
    }

}
