package com.assessment.creditcard.services;

import com.assessment.creditcard.dto.CreditCardResponse;
import com.assessment.creditcard.model.CreditCardEntity;
import com.assessment.creditcard.repo.CreditCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepo repo;

    public List<CreditCardEntity> fetchCreditCardList(){
        return repo.findAll();
    }

    public CreditCardResponse saveCreditCardToDB(String number){
        CreditCardEntity entity;
        Optional<CreditCardEntity> existing = repo.findByNumber(number);
        if(existing.isEmpty()) {
             CreditCardEntity newEntity = new CreditCardEntity();
             newEntity.setNumber(number);
             entity = repo.save(newEntity);
        }
        else {
            entity = existing.get();
        }
        CreditCardResponse response = new CreditCardResponse(entity.getId(), entity.getNumber());
        return response;
    }

    public CreditCardResponse fetchCreditCardById(int id){
        CreditCardResponse response = null;
        Optional<CreditCardEntity> data = repo.findById(id);
        if(data.isPresent()){
           response = new CreditCardResponse(id, data.get().getNumber());
        }
        return response;
    }
}
