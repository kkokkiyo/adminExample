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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"orderDetailList", "partner"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String name;

    private String title;

    private String content;

    private Integer price;

    private String brandName;

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

    // Item N : 1 Partner
    @ManyToOne
    private Partner partner;

    // Item 1 : N OrderDetail
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;



//    //1 : N
//    //LAZY = 지연 로딩, EAGER = 즉시 로딩
//    //LAZY = SELECT * FROM item where id = ?
//
//
//    //EAGER = 1 : 1일 때 추천, 실행 즉시 연관관계가 설정된 모든 테이블에 대해서 로딩한다. 데이터가 많으면 성능저하 등의 위험이 있어 LAZY 타입 추천.
//    //item_id = order_detail.item_id
//    //user_id = order_detail.user_id
//    //where item.id = ?
//    //JOIN item item0_left outer join order_detail orderdetai1_on item0_.id=orderdetai1_.item_id left outer join user user2_on orderdetai1_.user_id=user2_.id
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
//    private List<OrderDetail> orderDetailList;

}
