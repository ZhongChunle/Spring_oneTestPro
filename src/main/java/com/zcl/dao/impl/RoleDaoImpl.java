package com.zcl.dao.impl;

import com.zcl.dao.RoleDao;
import com.zcl.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 项目名称：Spring_oneTestPro
 * 描述：实现RoleDao接口类
 *
 * @author zhong
 * @date 2022-05-02 23:19
 */
public class RoleDaoImpl implements RoleDao {
    /**
     * com.zcl.dao.impl.RoleDaoImpl.()
     * Dao注入JdbcTemplate模板
     *
     * @author zhong
     * @date 2022/5/2 23:22
     * @param  null
     * @return
     */
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * com.zcl.dao.impl.RoleDaoImpl.findAll()
     * 调用JdbcTemplate模板里面的query()方法查询所有的角色信息
     *
     * @author zhong
     * @date 2022/5/2 23:22
     * @param
     * @return java.util.List<com.zcl.domain.Role>
     */
    @Override
    public List<Role> findAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role",new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    /**
     * com.zcl.dao.impl.RoleDaoImpl.save()
     * 通过jdbcTemplate来完成dao语句新增角色信息
     *
     * @author zhong
     * @date 2022/5/3 8:38
     * @param  role
     * @return void
     */
    @Override
    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role values(?,?,?)",null,role.getRoleName(),role.getRoleDesc());
    }
}
