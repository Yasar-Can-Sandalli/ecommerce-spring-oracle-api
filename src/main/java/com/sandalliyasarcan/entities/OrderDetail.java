package com.sandalliyasarcan.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "order_details")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetail extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_detail_seq_gen")
    @SequenceGenerator(name = "order_detail_seq_gen", sequenceName = "order_detail_seq", allocationSize = 1)
    private Long orderDetailId;

    @Column(name = "quantity" , nullable = false)
    private Integer quantity;

    @Column(name = "unit_price" , nullable = false)
    private Double unitPrice;

    @Column(name = "total_price" , nullable = true)
    private Double totalPrice;


    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;




}
