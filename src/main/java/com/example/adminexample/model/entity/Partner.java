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
@ToString(exclude = {"itemList", "category"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String status;

    private String address;

    private String callCenter;

    private String partnerNumber;

    private String businessNumber;

    private String ceoName;

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

    // Partner 1 : N Item
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "partner")
    private List<Item> itemList;

    // Partner N : 1 Category
    @ManyToOne
    private Category category;


}
