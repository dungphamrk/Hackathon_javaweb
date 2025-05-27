package com.data.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Category {
    private int category_id;

    @NotBlank(message = "Tên sản phẩm không được để trống ")
    private String category_name;

    private String description;

    private int status;
}
