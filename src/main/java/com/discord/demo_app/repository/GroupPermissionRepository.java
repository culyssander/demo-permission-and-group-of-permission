package com.discord.demo_app.repository;

import com.discord.demo_app.model.GroupPermission;
import com.discord.demo_app.model.GroupPermissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GroupPermissionRepository extends JpaRepository<GroupPermission, GroupPermissionId> {

}
