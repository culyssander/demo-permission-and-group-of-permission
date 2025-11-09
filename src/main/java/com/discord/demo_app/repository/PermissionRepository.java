package com.discord.demo_app.repository;

import com.discord.demo_app.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {

    @Query( value = "select pt.* from user_permission_table upt, permission_table pt " +
            " where upt.user_id = ?1 and upt.permission_id = pt.permission_id "
            ,nativeQuery = true)
    List<Permission> findPermissionByUserId(Integer userId);

    @Query( value = "select pt.* from user_permission_table upt, permission_table pt " +
            " where upt.user_id = ?2 and upt.permission_id = pt.permission_id " +
            " and pt.name = ?1 "
            ,nativeQuery = true)
    Optional<Permission> findByPermissionNameAndUserId(String permissionName, Integer userId);

    @Query(value = "select pt.* " +
            "from group_table gt, group_permission_table gpt, permission_table pt " +
            "where gt.group_id = gpt.group_id  and pt.permission_id = gpt.permission_id ",
            nativeQuery = true)
    List<Permission> findAllPermissionByGroup();

    @Query(value = "select pt.* " +
            "from group_permission_table gpt, permission_table pt " +
            "where gpt.group_id = ?1  and pt.permission_id = gpt.permission_id ",
            nativeQuery = true)
    List<Permission> findAllPermissionByGroupId(Integer groupId);

//    Optional<Permission> findGroupPermissionByUserId(Integer userId);

    @Query(value = "select pt.* " +
            " from group_table gt, group_permission_table gpt, user_group_permission_table ugpt, permission_table pt " +
            " where gt.group_id = gpt.group_id and ugpt.group_id = gt.group_id " +
            " and pt.name = ?1 and ugpt.user_id = ?2 ",
            nativeQuery = true)
    Optional<Permission> findGroupPermissionByUserIdAndPermissionName(String permissionName, Integer userId);

}
