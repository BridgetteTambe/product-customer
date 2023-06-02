package com.bree.com.resources;

import com.bree.com.models.Cart;
import com.bree.com.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200/", "http://localhost:4200","http://localhost:4201","https://product-admin-view.vercel.app/"})
public class CartResource {

    @Autowired
    CartService cartService;
    private Logger LOGGER = LoggerFactory.getLogger(CartResource.class);

    @PostMapping("/cart")
    public Cart saveCartInfo(@RequestBody Cart cart) throws Exception {
        LOGGER.info("Rest request to save cart data:{}");
        if (cart.getId() != null) {
            throw new Exception("Cant save data with id");
        }
        return cartService.save(cart);
    }

    @PutMapping("/cart")
    public Cart updateCart(@RequestBody Cart cart) throws Exception {
        LOGGER.info("Rest request to update cart with id:");
        if (cart.getId() == null) {
            throw new Exception("Cant update cart with a null id:{}");
        }
        return cartService.save(cart);

    }

    @GetMapping("/cart/{id}")
    public Cart getCartById(@PathVariable Long id) {
        LOGGER.info("Rest request to get cart  by id:{}", id);
        return cartService.findById(id);
    }

    @GetMapping("/cart")
    List<Cart> findAll() {
        LOGGER.info("Rest request to get all cart:");
        return cartService.findAll();
    }

    @DeleteMapping("/cart/{id}")
    public void deleteCartById(@PathVariable Long id) {
        LOGGER.info("Rest request to delete cart by id:", id);
        cartService.deleteById(id);
    }

    @DeleteMapping("/cart")
    public void deleteAll() {
        LOGGER.info("Rest request to delete cart:");
        cartService.deleteAll();
    }

}
