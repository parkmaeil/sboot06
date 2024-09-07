package com.example.sboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO { // JSON 변환

    private Long id;
    private String username;
    private List<ReviewDTO> reviews;
    // 추가 작성...
}
