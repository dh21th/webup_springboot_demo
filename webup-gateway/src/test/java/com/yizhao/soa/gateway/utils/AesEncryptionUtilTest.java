package com.webup.soa.gateway.utils;

import com.webup.soa.GatewayApplicationBootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GatewayApplicationBootstrap.class)
@WebAppConfiguration
public class AesEncryptionUtilTest {

    @Test
    public void test() throws Exception {
        System.out.println(AesEncryptionUtil.encrypt("person_1639", AesEncryptionUtil.AES_CBC_PKCS5, "YZWL!@#$%^&*()_+"));

        System.out.println(AesEncryptionUtil.decrypt("3ga+dRh+rXhQyVfHM7QEZA==", AesEncryptionUtil.AES_CBC_PKCS5, "YZWL!@#$%^&*()_+"));
    }

}
