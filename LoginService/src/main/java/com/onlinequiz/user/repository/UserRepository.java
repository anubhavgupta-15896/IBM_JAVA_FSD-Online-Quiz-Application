package com.onlinequiz.user.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onlinequiz.user.entity.User;
public interface UserRepository extends JpaRepository<User,String>
{
    @Query("select count(*) from User where username=:username  and password=:password")
    public int getUserByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}
