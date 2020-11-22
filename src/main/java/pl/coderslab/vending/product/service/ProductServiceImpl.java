package pl.coderslab.vending.product.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.coderslab.vending.product.entity.PackShape;
import pl.coderslab.vending.product.entity.Product;
import pl.coderslab.vending.product.repository.PackRepository;
import pl.coderslab.vending.product.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final PackRepository packRepository;

    public ProductServiceImpl(ProductRepository productRepository, PackRepository packRepository) {
        this.productRepository = productRepository;
        this.packRepository = packRepository;
    }



//    public Page<Product> getProducts(int pageNum,String sortField, String sortDir, String keyword) {
//        return productRepository.findAll(pageNum, sortField, sortDir, keyword);
//    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public List<PackShape> getPackshape() {
        return packRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProduct(long id) {
        Optional< Product > optional = productRepository.findById(id);
        Product product = null;
        if (optional.isPresent()) {
            product = optional.get();
        } else {
            throw new RuntimeException(" Product not found for id :: " + id);
        }
        return product;
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.productRepository.findAll(pageable);
    }
}
