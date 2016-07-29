package loc.ecs.service;

import loc.ecs.entity.Products;
import java.util.List;

public interface ProductsService {
    Products addProducts(Products product);
    Products getProductsById(int id);
    Products editProduct(Products product);
    void delete(int id);
    List<Products> getAll();
    List<Products> getLast10Rows();
}

