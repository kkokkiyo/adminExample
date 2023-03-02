package com.example.adminexample.repository;

import com.example.adminexample.model.SearchParam;
import com.example.adminexample.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);



















//    //select * from user where account = ? << test03, test04 등 우리가 설정한 id 값들 대입 가능
//    Optional<User> findByAccount(String account);
//
//    //select * from user where email = ? << 우리가 설정한 email 값들 대입 가능
//    Optional<User> findByEmail(String email);
//
//    //select * from user where account = ? and email = ?
//    Optional<User> findByAccountAndEmail(String account, String email);
//

}
