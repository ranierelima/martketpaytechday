package com.conductor.marketpay.web.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conductor.marketpay.base.model.User;
import com.conductor.marketpay.base.service.UserService;
import com.conductor.marketpay.web.controller.generic.BasicController;
import com.conductor.marketpay.web.response.GenericMessage;
import com.conductor.marketpay.web.response.GenericMessageErrorDTO;
import com.conductor.marketpay.web.security.SecurityUtil;

@RestController
@RequestMapping("/user")
public class UserController extends BasicController<User> {

	private static final String DEFAULT_PASS = "123456";

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private static final String ERROR_EMAIL_JA_CADASTRADO = "Cadastro não pode ser realizado pois o e-mail informado já está cadastrado";

	@Autowired
	public UserController(UserService service, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super(service);
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	public GenericMessage save(@Valid @RequestBody User model, BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		if (model != null) {
			if (model.getId() == null && model.getEmail() != null
					&& ((UserService) service).emailAlreadyRegistered(model.getEmail())) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				return new GenericMessageErrorDTO(HttpServletResponse.SC_CONFLICT, ERROR_EMAIL_JA_CADASTRADO);
			}

			String pass = model.getPassword();
			
			if ( model.getId() == null ) {

				if (pass == null || pass.isEmpty() )  {
					
					pass = DEFAULT_PASS;
				}
				
				model.setPassword(bCryptPasswordEncoder.encode(pass));
				model.setActive(true);
				
			} else {
				
				User userDB = ((UserService) service).get(model.getId()).get();

				String passwordDB = userDB.getPassword();
				
				if (pass == null || pass.isEmpty() )  {
					
					model.setPassword(passwordDB);
				} else if ( !passwordDB.equals(bCryptPasswordEncoder.encode(pass)) ) {
					model.setPassword(bCryptPasswordEncoder.encode(pass));
				}
				
			} // if-else


		}

		return super.save(model, bindingResult, request, response);
	}

	@GetMapping("/data")
	public User getData(HttpServletResponse response) throws IOException {
		Optional<User> optionalUser = service.get(SecurityUtil.getUserId());
		if (!optionalUser.isPresent()) {
			response.sendError(HttpStatus.NOT_FOUND.value());
		}
		return optionalUser.get();
	}

}
