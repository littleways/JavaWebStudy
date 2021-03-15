package com.bean;

import com.dao.UserMapper;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 用户信息类
 *
 * @author Littleway
 */
public class User {
    private String userid;
    private String username;
    private String password;
    private String email;

    public User(String userId, String username, String password, String mail) {
        this.userid = userId;
        this.username = username;
        this.password = password;
        this.email = mail;
    }

    public void insert() {
        try (SqlSession session = MybatisUtils.getInstance().getSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.insert(this);
            session.commit();
        }
    }

    public void update() {
        try (SqlSession session = MybatisUtils.getInstance().getSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.update(this);
            session.commit();
        }
    }

    public static List<User> selectAllUser() {
        try (SqlSession session = MybatisUtils.getInstance().getSession()) {
            UserMapper mapper;
            mapper = session.getMapper(UserMapper.class);
            return mapper.selectAllUser();
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + email + '\'' +
                '}';
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
