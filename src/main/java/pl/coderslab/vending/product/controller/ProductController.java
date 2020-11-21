package pl.coderslab.vending.product.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.vending.product.entity.PackShape;
import pl.coderslab.vending.product.entity.Product;
import pl.coderslab.vending.product.service.ProductServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {
    private final ProductServiceImpl productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }



    @GetMapping("/addproduct")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "addproductform";
    }

    @PostMapping("/addproduct")
    public String addProduct(@ModelAttribute("machine") Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addproductform";
        }
        productServiceImpl.saveProduct(product);
        return "redirect:/products?success";
    }

    @GetMapping("/products")
    public String allProducts(Model model, @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Product> products = productServiceImpl.getProducts(pageable);
        //List<PackShape> packs=productServiceImpl.getPackshape();
        model.addAttribute("products", products);
        model.addAttribute("currentPage",page);
        //model.addAttribute("data", productServiceImpl.getProducts(new PageRequest(page,10)));
        return "products";
    }

    @GetMapping("/deleteproduct/{id}")
    public String delete(@PathVariable Long id) {
        productServiceImpl.deleteById(id);
        return "redirect:/products";
    }
    @GetMapping("/editproduct/{id}")
    public String editMachineForm(@PathVariable Long id, Model model) {
        Product product = productServiceImpl.getProduct(id);
        model.addAttribute("product", product);
        return "editproductform";
    }

    @PostMapping("/editproduct")
    public String editMachine(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "editproductform";
        }

        productServiceImpl.saveProduct(product);
        return "redirect:/products?success";
    }


}
