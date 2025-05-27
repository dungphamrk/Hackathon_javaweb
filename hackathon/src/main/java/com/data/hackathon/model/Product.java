package com.data.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    private int product_id;

    @NotBlank(message = "Tên sản phẩm không được để trống")
    private String product_name;

    private String description;

    @NotBlank(message = "Giá sản phẩm không đuợc để trống")
    @Min(value = 0, message = "Giá sản phẩm phải lớn hơn 0")
    private double price;

    private int status;

    private LocalDateTime created_at;
    private String image;

    private String category_name;
}
