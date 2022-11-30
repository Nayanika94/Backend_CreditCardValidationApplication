package com.assessment.creditcard.repo;


import com.assessment.creditcard.model.CreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreditCardRepo extends JpaRepository<CreditCardEntity,Integer> {

    Optional<CreditCardEntity> findByNumber(String number);
}
