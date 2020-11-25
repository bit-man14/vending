package pl.coderslab.vending.product.controller;

import org.springframework.data.domain.Page;

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
    public String addProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addproductform";
        }
        productServiceImpl.saveProduct(product);
        return "redirect:/products?success";
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        return findPaginated(1, "name", "asc", model);
    }

    @GetMapping("/products/page/{pageNum}")
    public String findPaginated(@PathVariable(name = "pageNum") int pageNum,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {

        int pageSize = 10;
        Page<Product> page = productServiceImpl.findPaginated(pageNum, pageSize, sortField, sortDir);
        List<Product> listProducts = page.getContent();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("listProducts", listProducts);

        List<PackShape> packShape = productServiceImpl.getPackshape();

        model.addAttribute("packShape", packShape);

        return "products";
    }

    @GetMapping("/deleteproduct/{id}")
    public String delete(@PathVariable Long id) {
        productServiceImpl.deleteById(id);
        return "redirect:/products";
    }

    @GetMapping("/editproduct/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        Product product = productServiceImpl.getProduct(id);
        //List<Product> products=productServiceImpl.getProducts();
        List<PackShape> packShapes=productServiceImpl.getPackshape();
        model.addAttribute("product", product);
        model.addAttribute("packshapes", packShapes);
        return "editproductform";
    }

    @PostMapping("/editproduct")
    public String editProduct(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "editproductform";
        }

        productServiceImpl.saveProduct(product);
        return "redirect:/products?success";
    }


}
