package com.ecommerce.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseModel {
    private long id;
    private Long createdAt;
    private Long updatedAt;
}
