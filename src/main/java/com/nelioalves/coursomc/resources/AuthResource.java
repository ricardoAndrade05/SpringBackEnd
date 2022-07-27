package com.nelioalves.coursomc.resources;

import javax.servlet.http.HttpServletResponse;

import static com.nelioalves.coursomc.security.JWTUtil.TIPO_TOKEN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.coursomc.security.JWTUtil;
import com.nelioalves.coursomc.security.UserSS;
import com.nelioalves.coursomc.services.UserService;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

	@Autowired
	private JWTUtil jwtUtil;

	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSS user = UserService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", TIPO_TOKEN + token);
		return ResponseEntity.noContent().build();
	}

}
