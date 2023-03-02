package com.example.adminexample.model.entity;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class AdminUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private String password;

    private String status;

    private String role;

    private LocalDateTime lastLoginAt;

    private LocalDateTime passwordUpdatedAT;

    private int loginFailCount;  // 0으로 초기화 하기 위해서 int형으로 선언 - int는 null로 초기화 불가 (데이터 타입이지 객체가 아니기 때문)

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    @CreatedDate  // JPA Auditing을 이용해서 자동으로 생성
    private LocalDateTime createdAt;

    @CreatedBy  // JPA Auditing을 이용해서 자동으로 생성
    private String createdBy;

    @LastModifiedDate  // JPA Auditing을 이용해서 자동으로 생성
    private LocalDateTime updatedAt;

    @LastModifiedBy  // JPA Auditing을 이용해서 자동으로 생성
    private String updatedBy;
}
