package com.whitebear.repository;

import com.whitebear.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User save(User user);
    boolean existsByEmail(String email);
}
