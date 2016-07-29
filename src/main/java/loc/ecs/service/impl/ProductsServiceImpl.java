package loc.ecs.service.impl;

import loc.ecs.entity.Products;
import loc.ecs.repository.ProductsRepository;
import loc.ecs.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public Products addProducts(Products product) {
        return productsRepository.saveAndFlush(product);
    }

    @Override
    public Products getProductsById(int id) {
        Products product;
        if (productsRepository.exists(id)) {
            product = productsRepository.getOne(id);
        }
        else {
            product = new Products(0, "Not Found", "Not Found", 0, "Not Found") ;
        }
        return product;
    }

    @Override
    public Products editProduct(Products product) {
        return productsRepository.saveAndFlush(product);
    }

    @Override
    public void delete(int id) {
        productsRepository.delete(id);
    }

    @Override
    public List<Products> getAll() {
        return productsRepository.findAll();
    }

    @Override
    public List<Products> getLast10Rows() {
        return productsRepository.getLastTenRows();
    }
}
