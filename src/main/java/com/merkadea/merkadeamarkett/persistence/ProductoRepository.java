package com.merkadea.merkadeamarkett.persistence;

import com.merkadea.merkadeamarkett.domain.Product;
import com.merkadea.merkadeamarkett.domain.repository.ProductRepository;
import com.merkadea.merkadeamarkett.persistence.crud.ProductoCrudRepository;
import com.merkadea.merkadeamarkett.persistence.entity.Producto;
import com.merkadea.merkadeamarkett.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
// nuestra base de datos, pues aqui estas las orecion q queremos aplicar a nuestras tables
@Repository //le esta indicando que esta case interactura con
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired //en auto y ya no manualmente
    private ProductMapper mapper;

    //un metodo q recupere una lista de productos de una bases de datos
    @Override
    public List<Product> getAll()
    {
        List<Producto> productos=(List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos=productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScardeProducts(int quantity) {
        Optional<List<Producto>> productos= productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods->mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {

        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));//obtenet un pro dado su id
    }

    @Override
    public Product save(Product product) {
        Producto producto=mapper.toProducto(product);

        return mapper.toProduct(productoCrudRepository.save(producto)) ;
    }





    //para guradr un produc

    //para eliominar u pr dec de api
    @Override
    public void delete(int productId)
    {
        productoCrudRepository.deleteById(productId);
    }
}
