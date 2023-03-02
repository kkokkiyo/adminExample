package com.example.adminexample.repository;

import com.example.adminexample.AdminExampleApplicationTests;
import com.example.adminexample.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest extends AdminExampleApplicationTests {

    //Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository; //단 하나만 생성해 두고 싱글톤 패턴으로 사용을 하겠다.


    @Test
    public void create(){

        String account = "Test03";
        String password = "Test03";
        String status = "REGISTERED";
        String email = "Test01@gamil.com";
        String phoneNumber = "010-1111-3333";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        //Complete Current Statement(현재 구문 완성), ⇧⌘⏎(MacOS)
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
//        user.setCreatedAt(createdAt);
//        user.setCreatedBy(createdBy);

        User u = User.builder().account(account).password(password).status(status).email(email).build();
        //User 클래스에 @Builder 어노테이션을 달면 위 처럼 원하는 매개변수를 선택해서 객체를 생성할 수 있다. 끝은 build()로 끝난다.

        User newUser = userRepository.save(user);
        assertNotNull(newUser);

    }

    @Test
    @Transactional
    public void read(){

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        if(user != null){
            user.getOrderGroupList().stream().forEach(orderGroup -> {

                System.out.println("------------주문묶음------------");
                System.out.println("수령인: " + orderGroup.getRevName());
                System.out.println("수령지: " + orderGroup.getRevAddress());
                System.out.println("총금액: " + orderGroup.getTotalPrice());
                System.out.println("총수량: " + orderGroup.getTotalQuantity());

                System.out.println("------------주문상세------------");
                orderGroup.getOrderDetailList().forEach(orderDetail -> {
                    System.out.println("파트너사 이름: " + orderDetail.getItem().getPartner().getName());
                    System.out.println("파트너사 카테고리: " + orderDetail.getItem().getPartner().getCategory().getTitle());
                    System.out.println("주문 상품: " + orderDetail.getItem().getName());
                    System.out.println("고객센터 번호: " + orderDetail.getItem().getPartner().getCallCenter());
                    System.out.println("주문의 상태: " + orderDetail.getStatus());
                    System.out.println("도착예정일자: " + orderDetail.getArrivalDate());
                });

            });
        }


        assertNotNull(user);

    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("PPPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });

    }

    @Test
    public void delete(){

        Optional<User> user = userRepository.findById(6L);

        assertTrue(user.isPresent()); //True

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(6L);

        assertFalse(deleteUser.isPresent()); //False

        }
    }




