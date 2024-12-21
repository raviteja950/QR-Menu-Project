package com.MenuQR.Project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MenuQR.Project.Dao.ResturentRegistrationDaoImpl;
import com.MenuQR.Project.Entity.ResturentRegistrationEntity;
import com.MenuQR.Project.Service.JwtService;

@CrossOrigin(origins = { "*" }, maxAge = 3600L)
@Configuration
@RequestMapping("/User")
@RestController
public class UserController {

	@Autowired
	private ResturentRegistrationDaoImpl daoImpl;

	@Autowired
	private JwtService jwtService;

	@GetMapping("/fetchAllResturentDetails")
	public List<ResturentRegistrationEntity> fetchAllResturentDetails(
			@RequestHeader("Authorization") String bearerToken) {
		try {

			String[] authorizationToken = bearerToken.split("Bearer ");
			String token = null;
			for (String value : authorizationToken) {
				token = value;
			}
			boolean result = jwtService.isTokenExpired(token);
			if (result == false) {
				return daoImpl.fetchAllResturentDetails();
			} else {
				System.out.println("token expired");
				return null;
			}

		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

}
