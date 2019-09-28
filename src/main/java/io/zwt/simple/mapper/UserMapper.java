package io.zwt.simple.mapper;

import io.zwt.simple.model.SysRole;
import io.zwt.simple.model.SysUser;

import java.util.List;

public interface UserMapper {

    /**
     * 通过id查询用户
     *
     * @param id
     * @return
     */

    SysUser selectById(Long id);

    /**
     * 查询全部用户
     *
     * @return
     */
    List<SysUser> selectAll();

    /**
     * 根据用户 id 获取角色信息
     *
     * @param userId
     * @return
     */
    List<SysRole> selectRolesByUserId(Long userId);

    /**
     * 新增用户
     *
     * @param
     * @return
     */
    int insert(SysUser sysUser);
}
