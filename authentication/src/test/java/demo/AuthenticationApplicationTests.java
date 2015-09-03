package demo;

import com.lennonjesus.experiments.authentication.AuthenticationApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AuthenticationApplication.class)
@WebAppConfiguration
public class AuthenticationApplicationTests {

	@Test
	public void contextLoads() {
	}

}
