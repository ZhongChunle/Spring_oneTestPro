package com.zcl.dao.impl;

import com.zcl.dao.UserDao;
import com.zcl.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * 项目名称：Spring_oneTestPro
 * 描述：用户列表接口实现类
 *
 * @author zhong
 * @date 2022-05-03 9:18
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    /**
     * com.zcl.dao.impl.UserDaoImpl.save()
     * 新增保存用户数据，返回新增数据的userId
     *
     * @author zhong
     * @date 2022/5/4 9:16
     * @param  user
     * @return java.lang.Long
     */
    @Override
    public Long save(User user) {
        // jdbcTemplate.update("insert into sys_user values(?,?,?,?,?)",null,user.getUsername(),user.getEmail(),user.getPassword(),user.getPhoneNum());

        // 1、创建PreparedStatementCreator
        PreparedStatementCreator creator = new PreparedStatementCreator(){
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                // 使用原始的jdbc完成有个PreparedStatement的主键
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1,null);
                preparedStatement.setString(2,user.getUsername());
                preparedStatement.setString(3,user.getEmail());
                preparedStatement.setString(4,user.getPassword());
                preparedStatement.setString(5,user.getPhoneNum());
                return preparedStatement;
            }
        };

        // 2、创建keyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(creator,keyHolder);

        // 3、获得生成的主键
        long userId = keyHolder.getKey().longValue();
        System.out.println("获取新增的主键："+userId);
        return userId;
    }

    /**
     * com.zcl.dao.impl.UserDaoImpl.saveUserRolel()
     * 根据新增的用户id新增角色信息
     *
     * @author zhong
     * @date 2022/5/4 9:17
     * @param  userId
     * @param  roleIds
     * @return void
     */
    @Override
    public void saveUserRolel(Long userId, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role values(?,?)",userId,roleId);
        }
    }

    /**
     * com.zcl.dao.impl.UserDaoImpl.delUserRole()
     * 根据用户id删除中间表的角色信息
     *
     * @author zhong
     * @date 2022/5/5 13:13
     * @param  userId
     * @return void
     */
    @Override
    public void delUserRole(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId = ?",userId);
    }

    /**
     * com.zcl.dao.impl.UserDaoImpl.del()
     * 根据id删除具体的用户本身数据
     *
     * @author zhong
     * @date 2022/5/5 13:13
     * @param  userId
     * @return void
     */
    @Override
    public void del(Long userId) {
        jdbcTemplate.update("delete from sys_user where id = ?",userId);

    }
}
