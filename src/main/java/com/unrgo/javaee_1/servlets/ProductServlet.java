package com.unrgo.javaee_1.servlets;

import com.unrgo.javaee_1.model.Product;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Set;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    @Inject
    Product product;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        product.setTitle("Book");
        product.setPrice(2000);
        product.setDescription("Some description");

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<Product>> validate = validator.validate(product);

        if(validate.size() > 0){
            for(ConstraintViolation<Product> violation : validate){
                System.out.println("Some error occurred");
                System.out.println(violation.getMessage());
                System.out.println(violation.getInvalidValue());
            }
        }

        Set<ConstraintViolation<Product>> validatedTitle = validator.validateProperty(product, "title");

        if(validatedTitle.size() > 0){
            System.out.println("Title is wrong");
        }

        Set<ConstraintViolation<Product>> validatedPrice = validator.validateValue(Product.class, "price", 100);
        if(validatedPrice.size() > 0){
            System.out.println("Price 100 is wrong");
        }

        try {
            Method setTitle = Product.class.getMethod("setTitle", String.class);
            ExecutableValidator executableValidator = validator.forExecutables();
            Set<ConstraintViolation<Class<Product>>> constraintViolations = executableValidator.validateParameters(Product.class, setTitle, new Object[]{null});
            if(constraintViolations.size() > 0){
                System.out.println("Parameter was wrong");
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Set<ConstraintViolation<Product>> imageURLValidate = validator.validateValue(Product.class, "imageURL", "https://localhost:3030/img/1");
        for (ConstraintViolation violation : imageURLValidate){
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }


        validatorFactory.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
