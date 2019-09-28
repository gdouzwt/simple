package io.zwt.simple.mapper;

import io.zwt.simple.model.SysRole;
import io.zwt.simple.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class UserMapperTest extends BaseMapperTest {


    @Test
    public void testSelectById() {
        // 获取sqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取 UserMapper 接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 调用 selectById 方法，查询 id = 1 的用户
            SysUser user = userMapper.selectById(1l);
            // user 不为空
            Assert.assertNotNull(user);
            // userName = admin
            Assert.assertEquals("admin", user.getUserName());
        } finally {
            // 不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //调用 selectAll 方法查询所有用户
            List<SysUser> userList = userMapper.selectAll();
            // 结果不为空
            Assert.assertNotNull(userList);
            // 用户数量大于 0 个
            Assert.assertTrue(userList.size() > 0);

        } finally {
            // 不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserId() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 调用 selectRolesByUserId 方法，查询 id = 1 的用户的角色
            List<SysRole>  roleList =  userMapper.selectRolesByUserId(1l);
            // 结果不为空
            Assert.assertNotNull(roleList);
            // 角色数量大于 0 个
            Assert.assertTrue(roleList.size() > 0);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsert() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 创建一个 user 对象
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@zwt.io");
            user.setUserInfo("I love you, Wing!");
            // 正常情况下应该读入一张图片存到 byte 数组中
            user.setHeadImg(new byte[]{1,2,3});
            user.setCreateTime(new Date());
            // 将新建的对象插入数据库中，特别注意这里的返回值 result 是执行的 SQL 影响的行数
            int result = userMapper.insert(user);
            // 直插入 1 条数据
            Assert.assertEquals(1, result);
            // id 为 null，没有给 id 赋值，并且没有配置回写 id 的值
            Assert.assertNull(user.getId());
        } finally {
            // 为了不影响其他测试，这里选择回滚
            // 由于默认的 sqlSessionFactory.openSession()是不自动提交的
            // 因此不手动执行 commit 也不会提交到数据库
            sqlSession.rollback();
            // 不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testInsert2() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 创建一个 user 对象
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@zwt.io");
            user.setUserInfo("I love you, Wing!");
            // 正常情况下应该读入一张图片存到 byte 数组中
            user.setHeadImg(new byte[]{1,2,3});
            user.setCreateTime(new Date());
            // 将新建的对象插入数据库中，特别注意这里的返回值 result 是执行的 SQL 影响的行数
            int result = userMapper.insert2(user);
            // 直插入 1 条数据
            Assert.assertEquals(1, result);
            // 因为 id 回写，所以 id 不为 null
            Assert.assertNotNull(user.getId());
        } finally {
            // 为了不影响其他测试，这里选择回滚
            // 由于默认的 sqlSessionFactory.openSession()是不自动提交的
            // 因此不手动执行 commit 也不会提交到数据库
            sqlSession.rollback();
            // 不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testInsert3() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 创建一个 user 对象
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@zwt.io");
            user.setUserInfo("I love you, Wing!");
            // 正常情况下应该读入一张图片存到 byte 数组中
            user.setHeadImg(new byte[]{1,2,3});
            user.setCreateTime(new Date());
            // 将新建的对象插入数据库中，特别注意这里的返回值 result 是执行的 SQL 影响的行数
            int result = userMapper.insert3(user);
            // 直插入 1 条数据
            Assert.assertEquals(1, result);
            // 因为 id 回写，所以 id 不为 null
            Assert.assertNotNull(user.getId());
        } finally {
            // 为了不影响其他测试，这里选择回滚
            // 由于默认的 sqlSessionFactory.openSession()是不自动提交的
            // 因此不手动执行 commit 也不会提交到数据库
            sqlSession.rollback();
            // 不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }
}
