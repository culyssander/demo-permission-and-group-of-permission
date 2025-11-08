package com.discord.demo_app.repository;

import com.discord.demo_app.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
