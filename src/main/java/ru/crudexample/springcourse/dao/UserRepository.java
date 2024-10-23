package ru.crudexample.springcourse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.crudexample.springcourse.models.User;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
//    @Query("from User u where u.email = ?1")
    User getByEmail(String email);
    @Modifying
    @Query("delete from User u where u.email = ?1")
    void deleteByEmail(String email);

    @Query("from User u where u.login = ?1")
    User getUserByLogin(String login);

    @Modifying
    @Query("delete from User u where u.id =?1")
    void deleteUserById(UUID id);

    UserDetails getByLogin(String login);

    Optional<User> findByLogin(String login);
}
