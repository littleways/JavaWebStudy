package com.service;

import com.bean.User;
import com.enumType.enums.LOGIN_ERROR_CORD;
import com.enumType.enums.REGISTER_ERROR_CORD;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Littleway
 */
public class UserManager {
    private static final String USER_NAME = "username";
    private static final String PASS_WORD = "password";
    private static final String RE_PASS_WORD = "repwd";
    private static final String EMAIL = "email";

    private final ConcurrentHashMap<String, User> allUser;

    private UserManager() {
        allUser = new ConcurrentHashMap<>();
        List<User> users = User.selectAllUser();
        for (User user : users) {
            allUser.put(user.getUsername(), user);
        }
    }

    /**
     * 新用户注册
     */
    public void registUser(String uid, String username, String passowrd, String email) {
        User user = new User(uid, username, passowrd, email);
        user.insert();
        allUser.put(user.getUsername(), user);
    }

    /**
     * 验证注册信息
     */
    public int checkRegisterInfo(Map<String, String[]> parameterMap) {

        //验证信息完整性
        if (!parameterMap.containsKey(USER_NAME) || "".equals(parameterMap.get(USER_NAME)[0])) {
            return REGISTER_ERROR_CORD.USER_NAME_LESS.ordinal();
        }
        //查看注册账号是否已经存在
        if (allUser.containsKey(parameterMap.get(USER_NAME)[0])) {
            return REGISTER_ERROR_CORD.USER_NAME_LESS.ordinal();
        }
        if (!parameterMap.containsKey(PASS_WORD) || "".equals(parameterMap.get(PASS_WORD)[0])) {
            return REGISTER_ERROR_CORD.USER_PASSWD_LESS.ordinal();
        }
        if (!parameterMap.containsKey(RE_PASS_WORD) || "".equals(parameterMap.get(RE_PASS_WORD)[0])) {
            return REGISTER_ERROR_CORD.USER_REPASSWD_LESS.ordinal();
        }
        if (!parameterMap.containsKey(EMAIL) || "".equals(parameterMap.get(EMAIL)[0])) {
            return REGISTER_ERROR_CORD.USER_EMIL_LESS.ordinal();
        }
        //验证密码
        if (!parameterMap.get(PASS_WORD)[0].equals(parameterMap.get(RE_PASS_WORD)[0])) {
            return REGISTER_ERROR_CORD.RE_PASSWD_ERROR.ordinal();
        }
        //验证邮箱
        return REGISTER_ERROR_CORD.SUCCESS.ordinal();
    }

    /**
     * 验证玩家登录信息
     */
    public int checkLoginInfo(String username, String password) {
        //用户名验证
        if (username == null || "".equals(username) || !allUser.containsKey(username)) {
            return LOGIN_ERROR_CORD.USER_NAME_ERROR.ordinal();
        }
        //密码验证
        User loginUser = allUser.get(username);
        if (password == null || "".equals(password) || !loginUser.getPassword().equals(password)) {
            return LOGIN_ERROR_CORD.USER_PASS_WORD_ERROR.ordinal();
        }
        return LOGIN_ERROR_CORD.SUCCESS.ordinal();
    }

    /**
     * 根据username获取用户数据
     *
     * @param username 用户账号
     * @return  返回的用户信息类
     */
    public User getUser(String username) {
        if (allUser.containsKey(username)) {
            return allUser.get(username);
        }
        return null;
    }

    public List<User> serchUser(String searchKey){
        List<User> userList = new ArrayList<>();
        for (User user : allUser.values()) {
            String username = user.getUsername();

            for (int i = 0; i < searchKey.length(); i++) {
                String s = String.valueOf(searchKey.charAt(i));
                if (username.contains(s)){
                    userList.add(user);
                }
            }
        }
        return userList;
    }

    /**
     * 单例
     */
    private static class LazyHolder {
        private static final UserManager INSTANCE;

        static {
            System.out.println("init static !!!!!!!!!!!!!!!!!");
            INSTANCE = new UserManager();
        }
    }

    public static UserManager getInstance() {
        return LazyHolder.INSTANCE;
    }
}
