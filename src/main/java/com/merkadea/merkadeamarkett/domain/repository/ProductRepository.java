package com.merkadea.merkadeamarkett.domain.repository;

import com.merkadea.merkadeamarkett.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    //en etsa claes vamos a indicar el nombr dde lso metodos que queremos que cuqien re q quiera trabajr tienes qye implementar
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);

    Optional<List<Product>> getScardeProducts(int quantity);//cantidfa
    Optional<Product> getProduct (int productId);
    Product save(Product product);
    void  delete(int productId);

}
