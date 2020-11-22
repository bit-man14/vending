package pl.coderslab.vending.product.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import pl.coderslab.vending.product.entity.PackShape;
import pl.coderslab.vending.product.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    List<PackShape> getPackshape();

    void saveProduct(Product product);

    Product getProduct(long id) throws ResourceNotFoundException;

    void deleteById(Long id);
    Page < Product > findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
