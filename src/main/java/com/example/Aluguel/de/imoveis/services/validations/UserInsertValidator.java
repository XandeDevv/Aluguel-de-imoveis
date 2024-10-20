package com.example.Aluguel.de.imoveis.services.validations;

import java.util.ArrayList;
import java.util.List;


import com.example.Aluguel.de.imoveis.controllers.exceptions.FieldMessage;
import com.example.Aluguel.de.imoveis.domains.Proprietario;
import com.example.Aluguel.de.imoveis.repositories.ProprietarioRepository;
import com.lojaroupas.loja.controllers.exceptions.FieldMessage;
import com.lojaroupas.loja.domains.User;
import com.lojaroupas.loja.dtos.UserInsertDto;
import com.lojaroupas.loja.repositories.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;



public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDto> {

    @Autowired
    private ProprietarioRepository proprietarioRepository;
    @Override
    public void initialize(UserInsertValid ann) {
    }

    @Override
    public boolean isValid(UserInsertDto dto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();
        Proprietario proprietario = proprietarioRepository.findByEmail(dto.getEmail());

        // Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
        if (proprietario!=null){
            list.add(new FieldMessage("email","email ja existe"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}