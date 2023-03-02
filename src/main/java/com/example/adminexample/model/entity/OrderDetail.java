package com.example.adminexample.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import net.bytebuddy.asm.Advice;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity  //order_detail
@ToString(exclude = {"orderGroup", "item"}) //연관관계에 있으면 투스트링을 자동으로 해주어 오버플로우가 나니 제외시켜주는게 좋다.
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    @CreatedDate  // JPA Auditing을 이용해서 자동으로 생성
    private LocalDateTime createdAt;

    @CreatedBy  // JPA Auditing을 이용해서 자동으로 생성
    private String createdBy;

    @LastModifiedDate  // JPA Auditing을 이용해서 자동으로 생성
    private LocalDateTime updatedAt;

    @LastModifiedBy  // JPA Auditing을 이용해서 자동으로 생성
    private String updatedBy;

    // OrderDetail N : 1 Item
    @ManyToOne
    private Item item;


    // OrderDetail N : 1 OrderGroup
    @ManyToOne
    private OrderGroup orderGroup;


//    //N : 1
//    @ManyToOne
//    private User user; //객체로 선언해두면 user_id를 알아서 찾아감
//
//
//    // N : 1
//    @ManyToOne
//    private Item item;
}
