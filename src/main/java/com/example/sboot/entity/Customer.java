package com.example.sboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    private String password;
    private String customerName;
    private  int age;
    private String rating;
    private String occupation;

    @Column(columnDefinition = "int default  0")
    private int reserves;

    // 고객(1) : 리뷰(N)
    @OneToMany(mappedBy ="customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews;  //  List<Review> reviews=cus.getReviews()

    // 고객(1) : 장바구니(N)
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Cart> carts;
}
