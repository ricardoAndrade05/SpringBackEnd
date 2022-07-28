package com.nelioalves.coursomc.resources;

import static com.nelioalves.coursomc.security.JWTUtil.TIPO_TOKEN;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.coursomc.dto.EmailDTO;
import com.nelioalves.coursomc.security.JWTUtil;
import com.nelioalves.coursomc.security.UserSS;
import com.nelioalves.coursomc.services.AuthService;
import com.nelioalves.coursomc.services.UserService;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthService authService;

	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSS user = UserService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", TIPO_TOKEN + token);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO emaildto) {
		authService.sendNewPassword(emaildto.getEmail());
		return ResponseEntity.noContent().build();
	}

}
