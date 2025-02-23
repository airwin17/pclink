package com.infomega.pclink.Services;

import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.model.checkout.Session;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import com.stripe.param.checkout.SessionCreateParams;
@Service
public class PayService {
    private final String STRIPE_SECRET="sk_test_51QtVOKH7xNdXl7YEA6YLLWXAhoH2IPvRdjE5oVICIXIuVAmxX4tLuWMlIdtfaeDQePBTqemc8lc8rc2oTEHgB6lW00eumAF5qU";
    public PayService() {
        
    }
    /**
     * get the checkout url for the payment
     * @throws StripeException 
     * **/
    public String getCheckoutUrl() throws  StripeException {
        //set the secret key
        Stripe.apiKey = STRIPE_SECRET;
        Session session;
        //create custom production for payment
        ProductCreateParams productParams=ProductCreateParams.builder()
            .setName("main d'oeuvre PC'Link")
            .build();
        Product product=Product.create(productParams);
        //create price for the product
        PriceCreateParams priceParams=PriceCreateParams.builder()
            
            .setCurrency("eur")
            .setProduct(product.getId())
            .setCustomUnitAmount(
                PriceCreateParams.CustomUnitAmount.builder().setEnabled(true).setMinimum(50L).build())
            .build();
        Price price=Price.create(priceParams);
        //create session for the payment
        SessionCreateParams sessionParam=SessionCreateParams.builder()
            .setMode(SessionCreateParams.Mode.PAYMENT)
            .setSuccessUrl("http://localhost:3000/successPayement")
            .setCancelUrl("http://localhost:3000/canceledPayement")
            .addLineItem(SessionCreateParams.LineItem
                .builder()
                .setPrice(price.getId())
                .setQuantity(1l)
                .build())
            .build();
        session=Session.create(sessionParam);
        return session.getUrl();    
    }
}
