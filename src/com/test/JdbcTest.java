package com.test;

import com.service.UserManager;
import com.utils.JdbcUtils;
import org.junit.Test;

public class JdbcTest {
    @Test
    public void testJdbcUtils(){
        UserManager instance = UserManager.getInstance();
        System.out.println(1111);
    }
}
