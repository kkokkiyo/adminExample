package com.example.adminexample.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.naming.ldap.PagedResultsControl;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // == table
@ToString(exclude = {"orderGroupList"})
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user") //클래스 이름과 db의 테이블 명이 똑같으면 굳이 이렇게 지정해주지 않아도 된다.
@Builder
//User 클래스에 @Builder 어노테이션을 달면 UserRepositoryTest에서 처럼
//User u = User.builder().account(account).password(password).status(status).email(email).build();
//이런식으로 원하는 매개변수를 선택해서 객체를 생성할 수 있다.  끝은 build()로 끝내야한다.
@Accessors(chain = true)
//체이닝을 통해 객체를 생성하거나 수정 할 수 있게 해준다.
//예를 들어 User u = new User().setAccount(account).setPassword(password).setStatus(status).setEmail(email);
//만약 이미 생성된 객체면, u.setAccount(account).setPassword(password).setStatus(status).setEmail(email);
//이런식으로 객체를 생성 혹은 수정할 수 있다.
public class User {
    @Id //식별자
    @GeneratedValue(strategy = GenerationType.IDENTITY) //어떤식으로 관리할 건지
    private long id;
    private String account;
    private String email;

    private String password;

    private String status;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    // @Column(name = "phone_number") 이렇게 지정해 줄 수도 있지만 db에 스네일로 만들고 Java에서 카멜로 만들어도 알아서 매칭해준다.
    //그리고 이 변수들의 명과 column의 명이 같으면 따로 지정해주지 않아도 된다.
    private String phoneNumber;
    @CreatedDate  // JPA Auditing을 이용해서 자동으로 생성
    private LocalDateTime createdAt;

    @CreatedBy  // JPA Auditing을 이용해서 자동으로 생성
    private String createdBy;

    @LastModifiedDate  // JPA Auditing을 이용해서 자동으로 생성
    private LocalDateTime updatedAt;

    @LastModifiedBy  // JPA Auditing을 이용해서 자동으로 생성
    private String updatedBy;

//    User 1 : N OrderGroup
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderGroup> orderGroupList;


//    //LAZY = 지연 로딩, EAGER = 즉시 로딩

}
