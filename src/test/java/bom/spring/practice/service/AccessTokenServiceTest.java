package bom.spring.practice.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@RunWith(SpringRunner.class)
public class AccessTokenServiceTest {

    @Autowired
    AccessTokenService accessTokenService;


    @Test
    public void testSaveToRedis(){
        String actual = accessTokenService.saveAccessToken("token");

        assertThat(actual).isEqualTo("token");
    }

}