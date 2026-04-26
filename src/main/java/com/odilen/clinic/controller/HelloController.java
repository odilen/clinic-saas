package com.odilen.clinic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Clinic SaaS backend funcionando 🚀";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hola Odilen, tu API está viva";
    }
}