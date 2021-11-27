package com.example.daggerapplication.data;

import javax.inject.Inject;

public class ProductDataSource {

    private final ProductDao productDao;

    @Inject
    public ProductDataSource(ProductDao productDao) {
        this.productDao = productDao;
    }

    public String getData() {
        return this.toString();
    }
}
