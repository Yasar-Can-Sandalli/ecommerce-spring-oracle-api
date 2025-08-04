package com.sandalliyasarcan.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_gen")
    @SequenceGenerator(name = "product_seq_gen", sequenceName = "product_seq", allocationSize = 1)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name", nullable = false, length = 50)
    private String productName;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "units_in_stock", nullable = false)// Buraya bir kisit getirmek istiyorum >0 olma kisiti
    private Integer unitsInStock;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false) //Bu anatasyonu bilmiyorum daha dogrusu iliski anotasyonlarini bilmiyorum ben mappedBy gormustum birkez o farkli sanrim  ,bunlara bereber Caliscaz Chat GPT !!
    private Category category;

    @Column(name = "brand" , nullable = false , length = 30)
    private String brand;

    @Column(name = "sku" , nullable = false , length = 15 , unique = true)
    private String sku;// birde bu sku ifadesi yaygin olarak kullanilan bir isimlendir me mi , productKod gibi bir isim versek olmaz mi ? , genel isimlendirme bu sekildeyse kalabilir ama





}
