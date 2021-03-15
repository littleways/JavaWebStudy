package com.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MybatisUtils {
    private SqlSessionFactory sqlSessionFactory = null;
    Lock lock;

    public MybatisUtils() {
        this.lock = new ReentrantLock();
    }

    private SqlSessionFactory getSqlSessionFactory() {
        if (this.sqlSessionFactory == null) {
            this.lock.lock();
            try {
                if (this.sqlSessionFactory == null) {
                    init();
                }
            } finally {
                this.lock.unlock();
            }
        }
        return this.sqlSessionFactory;
    }

    private void init() {
        {
            try {
                String xmlConfig = "/mybatis.xml";
                Reader reader = null;
                reader = Resources.getResourceAsReader(xmlConfig);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class LazyHolder {
        private static final MybatisUtils INSTANCE = new MybatisUtils();
    }

    public static MybatisUtils getInstance() {
        return LazyHolder.INSTANCE;
    }

    /**
     * 获取SqlSession对象方法
     *
     * @return
     */
    public SqlSession getSession() {
        return getSqlSessionFactory().openSession();
    }

}
