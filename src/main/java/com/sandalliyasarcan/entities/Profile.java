package com.sandalliyasarcan.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "profiles")
public class Profile extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_seq_gen")
    @SequenceGenerator(name = "profile_seq_gen", sequenceName = "profile_seq", allocationSize = 1)
    private Integer profileId;

    @Column(name = "image_url", nullable = true , length = 255)
    private String imageUrl;

    @Column(name = "username", nullable = false, length = 30, unique = true)
    private String username;

    @Column(name = "password", nullable = false, length = 150)
    private String password;

//    @ManyToMany
//    private List<Coupon> couponList = new ArrayList<>(); //Burayi newlemesek olmaz mi ?


    //Iliskinin Sahibi Degil - Week Entity --(Customer Classi 50.satir)
    @OneToOne(mappedBy = "profile")
    private Customer customer;



}
