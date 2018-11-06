package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    private ProductService productService = new ProductServiceImp();

    @GetMapping("/index")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/product/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/product/save")
    public ModelAndView save(Product product) {
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products", productService.findAll());
        modelAndView.addObject("success","Create successfully");
        return modelAndView;
    }

    @GetMapping("/product/{id}/edit")
    public ModelAndView edit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }

    @PostMapping("product/update")
    public ModelAndView update(Product product) {
        productService.update(product.getId(), product);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products", productService.findAll());
        modelAndView.addObject("success", "thành công");
        return modelAndView;
    }

    @GetMapping("/product/{id}/delete")
    public ModelAndView delete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }

    @PostMapping("/product/delete")
    public ModelAndView remove(Product product) {
        productService.remove(product.getId());
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products", productService.findAll());
        modelAndView.addObject("success", " xoá thành công");
        return modelAndView;
    }

    @GetMapping("/product/{id}/view")
    public ModelAndView view(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;

    }
}
