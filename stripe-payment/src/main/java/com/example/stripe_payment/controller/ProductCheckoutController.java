package com.example.stripe_payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stripe_payment.dto.ProductRequest;
import com.example.stripe_payment.dto.StripeResponse;
import com.example.stripe_payment.service.StripeService;

@RestController
@RequestMapping("/product/v1")
public class ProductCheckoutController {

    private StripeService stripeService;

    public ProductCheckoutController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @RequestMapping("/checkout")
    public ResponseEntity<StripeResponse> checkoutProducts(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(stripeService.checkoutProducts(productRequest));
    }
}
