package th.ac.kmutt.sit.MyFirstService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import th.ac.kmutt.sit.MyFirstService.controller.User;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyFirstServiceApplicationTests {

    @LocalServerPort
    private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
    public void getUserId5ByAttributeTest(){
        assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/user?id=4", User.class).getId())
                .isEqualTo(4);
        assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/user?id=4", User.class).getName())
                .isEqualTo("test4");
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

    @Test
    public void getUserId2ByUriTest(){
	    assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/user/2", User.class).getId())
                .isEqualTo(2);
        assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/user/2", User.class).getName())
                .isEqualTo("test2");
    }

}
