package com.qeema.task.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Order {

    private Long id;
    private Set<Product> products;

}