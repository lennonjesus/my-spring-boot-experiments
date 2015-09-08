package com.lennonjesus.experiments.authentication.repository;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.lennonjesus.experiments.authentication.AuthenticationApplication;
import com.lennonjesus.experiments.authentication.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @author Lennon Jesus
 */
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AuthenticationApplication.class)
@DatabaseSetup(UserRepositoryTest.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = { UserRepositoryTest.DATASET })
@DirtiesContext
public class UserRepositoryTest {

    protected static final String DATASET = "classpath:datasets/dataset.xml";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    DataSource dataSource;

    @Test
    public void testSenha() {
        String email = "lennon.jesus@gmail.com";

        Optional<User> user = userRepository.findOneByEmail(email);

        assertTrue(user.isPresent());
        assertEquals(email, user.get().getEmail());
        assertEquals("$2a$10$pz86SuNEFzn0.VMWDcs37u87kJlKU/NsLr04Mr1w8kXHi875miYZy", user.get().getPasswordHash());
    }

    @Test
    public void test() {

        List<User> userList = userRepository.findAll();

        assertNotNull(userList);
        assertFalse(userList.isEmpty());
        assertEquals(1, userList.size());

    }



}