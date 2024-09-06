package com.huuduy.ecommerce.repository;

import com.huuduy.ecommerce.model.AuthenticationToken;
import com.huuduy.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationTokenRepo extends JpaRepository<AuthenticationToken, Integer> {
    AuthenticationToken findByUser(User user);
}
