package com.assessment.creditcard.controller;

import com.assessment.creditcard.dto.CreditCardResponse;
import com.assessment.creditcard.services.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/creditcards")
public class CreditCardController {

    @Autowired
    private CreditCardService service;

    @PostMapping("/{number}")
    @CrossOrigin(origins = "http://localhost:62706", allowCredentials = "true")
    public CreditCardResponse saveCreditCardDetails(@PathVariable(name = "number") String number, HttpServletResponse response){
        CreditCardResponse creditCardInfo  = service.saveCreditCardToDB(number);
//        ResponseCookie resCookie = ResponseCookie.from("uuid", String.valueOf(creditCardInfo.getId()))
//                .httpOnly(true)
//                .secure(true)
//                .path("/")
//                .maxAge(86400)
//                .domain("localhost.com")
//                .build();
//        ResponseEntity.ok()
//                .header(HttpHeaders.SET_COOKIE, resCookie.toString())
//                .build();
//        response.addHeader("Set-Cookie", resCookie.toString());
//        response.setHeader("Access-Control-Allow-Headers",
//                "Date, Content-Type, Accept, X-Requested-With, Authorization, From, X-Auth-Token, Request-Id");
//        response.setHeader("Access-Control-Expose-Headers", "Set-Cookie");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
        return service.saveCreditCardToDB(number);
    }

    @GetMapping
    public CreditCardResponse fetchCreditCard(@RequestParam(name= "id",required=true) int id){
        return service.fetchCreditCardById(id);
    }
}
