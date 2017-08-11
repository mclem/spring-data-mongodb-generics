package com.mclem.repositories;

import com.mclem.entities.Identity;
import org.springframework.data.repository.CrudRepository;

public interface IdentityRepository extends CrudRepository<Identity, String> {
}