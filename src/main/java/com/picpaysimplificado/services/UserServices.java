package com.picpaysimplificado.services;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.picpaysimplificadore.repositories.UserRepository;
import java.math.BigDecimal;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository repository;
	
	public void validateTransaction(User sender, BigDecimal amount) throws Exception{
		if(sender.getUserType() == UserType.MERCHANT) {
			throw new Exception("Usuário do tipo lojista, não está autorizado a realizar transação");
			
		}
		if(sender.getBalance().compareTo(amount) <0) {
			throw new Exception("Usuário não tem saldo suficiente");

		}			
	}
}
