package com.kakaopay.kpcoupon.Store;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kakaopay.kpcoupon.Entity.User;

@Repository
@Configurable
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUserEmail(String email);

	
}
