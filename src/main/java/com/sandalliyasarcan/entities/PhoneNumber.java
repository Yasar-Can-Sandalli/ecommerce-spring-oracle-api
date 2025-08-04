package com.sandalliyasarcan.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "phone_numbers")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PhoneNumber extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_seq_gen")
    @SequenceGenerator(name = "phone_seq_gen", sequenceName = "phone_seq", allocationSize = 1)
    private Long phone_Id;

    @Column(name = "phone_type", nullable = false, length = 10)
    String phoneType;

    @Column(name = "phone_number", nullable = false, length = 13 , unique = true)
    private String phoneNumber;

    @ManyToOne()
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}
