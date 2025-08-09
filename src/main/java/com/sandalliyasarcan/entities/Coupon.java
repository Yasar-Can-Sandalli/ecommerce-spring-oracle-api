//package com.sandalliyasarcan.entities;
//
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "coupons")
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//public class Coupon extends BaseEntity{
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coupon_seq_gen")
//    @SequenceGenerator(name = "coupon_seq_gen", sequenceName = "coupon_seq", allocationSize = 1)
//    private Integer couponId;
//
//    @Column(name = "coupon_code" , nullable = false , length = 20 , unique = true)//kupon isimleri ayni olabilir lakin kupon kodlari farkli olmalidir
//    private String couponCode;
//
//
//    @Column(name = "coupon_name" , nullable = false , length = 20)
//    private String couponName;
//
//    @Column(name = "coupon_description" , nullable = false , length = 255)
//    private String couponDescription;
//
//    @Column(name = "coupon_start_date" ,  nullable = false)
//    private LocalDateTime couponStartDate;
//
//    @Column(name = "coupon_end_date" ,  nullable = false)
//    private LocalDateTime couponEndDate;
//
//    @Column(name = "coupon_status" , nullable = false )
//    private boolean couponStatus;
//
//}
