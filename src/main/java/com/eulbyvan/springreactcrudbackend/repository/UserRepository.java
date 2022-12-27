package com.eulbyvan.springreactcrudbackend.repository;

import com.eulbyvan.springreactcrudbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 27/12/2022
 */

public interface UserRepository extends JpaRepository<User, Long> {
}
