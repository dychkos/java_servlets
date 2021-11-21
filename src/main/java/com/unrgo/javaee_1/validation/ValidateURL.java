package com.unrgo.javaee_1.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.net.MalformedURLException;
import java.net.URL;

    public class ValidateURL implements ConstraintValidator<CheckURL,String> {
        String protocol;
        String host;
        int port;

        @Override
        public void initialize(CheckURL checkURL) {
            protocol = checkURL.protocol();
            host = checkURL.host();
            port = checkURL.port();

            ConstraintValidator.super.initialize(checkURL);

        }

        @Override
        public boolean isValid(String s, ConstraintValidatorContext context) {
            if(s == null || s.equals("")){
                return true;
            }

            java.net.URL url;
            try{
                url = new URL(s);
            }catch (MalformedURLException e){
                return false;
            }

            if(protocol != null && !protocol.equals("") && !protocol.equals(url.getProtocol())){
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("protocol is invalid").addConstraintViolation();
                return  false;
            }

            if(host != null && !host.equals("") && !host.equals(url.getHost())){
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("host is invalid").addConstraintViolation();
                return  false;
            }

            if(port != 3030 && port != url.getPort()){
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("port is invalid").addConstraintViolation();
                return  false;
            }

            return false;
        }
    }
