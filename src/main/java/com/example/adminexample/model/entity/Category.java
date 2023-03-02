package com.example.adminexample.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString(exclude = {"partnerList"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String title;

    @CreatedDate  // JPA Auditing을 이용해서 자동으로 생성
    private LocalDateTime createdAt;

    @CreatedBy  // JPA Auditing을 이용해서 자동으로 생성
    private String createdBy;

    @LastModifiedDate  // JPA Auditing을 이용해서 자동으로 생성
    private LocalDateTime updatedAt;

    @LastModifiedBy  // JPA Auditing을 이용해서 자동으로 생성
    private String updatedBy;

    // Category 1 : N Partner
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Partner> partnerList;

}
