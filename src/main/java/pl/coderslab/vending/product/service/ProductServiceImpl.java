package pl.coderslab.vending.product.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.coderslab.vending.machine.entity.Machine;
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



    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
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
    public Product getProduct(long id)  throws ResourceNotFoundException {
            return productRepository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException(String.valueOf(id)));
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
