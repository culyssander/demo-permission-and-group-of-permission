package com.discord.demo_app.repository;

import com.discord.demo_app.model.GroupPermission;
import com.discord.demo_app.model.GroupPermissionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupPermissionRepository extends JpaRepository<GroupPermission, GroupPermissionId> {
}
