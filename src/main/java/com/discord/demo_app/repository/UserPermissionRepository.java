package com.discord.demo_app.repository;

import com.discord.demo_app.model.UserPermission;
import com.discord.demo_app.model.UserPermissionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPermissionRepository extends JpaRepository<UserPermission, UserPermissionId> {
}
