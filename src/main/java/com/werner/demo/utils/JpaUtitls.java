package com.werner.demo.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/************************************************************************
 *                    .::::.                                            *
 *                  .::::::::.                                          *
 *                 :::::::::::                                          *
 *             ..:::::::::::'                                           *
 *           '::::::::::::'                                             *
 *             .::::::::::                                              *
 *        '::::::::::::::..                                             *
 *             ..::::::::::::.                                          *
 *           ``::::::::::::::::                                         *
 *            ::::``:::::::::'        .:::.                             *
 *           ::::'   ':::::'       .::::::::.                           *
 *         .::::'      ::::     .:::::::'::::.                          *
 *        .:::'       :::::  .:::::::::' ':::::.                        *
 *       .::'        :::::.:::::::::'      ':::::.                      *
 *      .::'         ::::::::::::::'         ``::::.                    *
 *  ...:::           ::::::::::::'              ``::.                   *
 * ```` ':.          ':::::::::'                  ::::..                *
 *                    '.:::::'                    ':'````..             *
 *              ━━━━━━━━━━━━━━━━━━━━━                                   *
 ************************************************************************
 *
 */
public class JpaUtitls {
    /**
     * 初始化一个ThreadLocal对象，ThreadLocal对象有get(),set()方法;
     */
    private static final ThreadLocal<EntityManager> sessionTL = new ThreadLocal<>();


    private static EntityManagerFactory emf;

    //静态代码块,只执行一次
    static {
        try {
            emf = Persistence.createEntityManagerFactory("jpa");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到EntityManager对象，同时设置EntityManager对象到ThreadLocal对象
     * 确保一个线程用一个EntityManager对象，而不是多个线程共享一个EntityManager对象
     *
     * @return 从ThradLocal对象中得到的EntityManager对象
     */
    public static EntityManager getEntityManager() {
        //多线程不公用session
        EntityManager em = sessionTL.get();
        if (em == null) {
            //得到em对象
            em = emf.createEntityManager();
            //将em对象保存到threadLocal对象中
            sessionTL.set(em);
        }
        return em;
    }
    /**
     * 关闭session ,同时从ThreadLocal对象中清除缓存
     */
    public static void close() {
        EntityManager em = sessionTL.get();
        sessionTL.set(null);//先清空threadLocal
        em.close();
    }
}
