package com.assessment.creditcard.dto;

public class CreditCardResponse {

    int id;
    String number;


    public CreditCardResponse() {
    }

    public CreditCardResponse(int id, String number) {
        this.id = id;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
