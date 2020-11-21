package pl.coderslab.vending.product.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import pl.coderslab.vending.product.entity.PackShape;
import pl.coderslab.vending.product.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    List<PackShape> getPackshape();

    void saveProduct(Product product);

    Product getProduct(long id) throws ResourceNotFoundException;

    void deleteById(Long id);
}
