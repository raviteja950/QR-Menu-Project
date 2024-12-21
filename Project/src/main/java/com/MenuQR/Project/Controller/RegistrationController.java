
package com.MenuQR.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MenuQR.Project.Dao.ResturentRegistrationDaoImpl;
import com.MenuQR.Project.Entity.ResturentRegistrationEntity;
import com.MenuQR.Project.Model.LoginResponce;
import com.MenuQR.Project.Model.ResturentRegistrationModel;
import com.MenuQR.Project.Model.StatusModel;
import com.MenuQR.Project.Service.JwtService;
import com.MenuQR.Project.Util.RequestValidation;


@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/auth")
@RestController
public class RegistrationController {

	@Autowired
	private ResturentRegistrationDaoImpl RegistrationImpl;

	@Autowired
	private JwtService jwtService;

	// regeistration for resturents
	@PostMapping("/restuarentRegistration")
	public ResturentRegistrationModel restuarentRegistration(
			@RequestBody ResturentRegistrationModel registationRequest) {

		ResturentRegistrationModel responce = new ResturentRegistrationModel();
		RequestValidation validation = new RequestValidation();
		StatusModel status = new StatusModel();
		try {

			// request validation
			status = validation.registrationValidation(registationRequest);
			if (status.getCode() == 200) {
				RegistrationImpl.saveResturantDetails(registationRequest);
				responce.setCode(200);
				responce.setMessage("User registered sucessfully");
			} else {
				responce.setCode(status.getCode());
				responce.setMessage(status.getMessage());
			}

		} catch (Exception e) {
			responce.setCode(400);
			responce.setMessage(e.toString());

		}
		return responce;
	}

	@PostMapping("/login")
	public LoginResponce authenticate(@RequestBody ResturentRegistrationModel resturentRegistrationModel) {
		ResturentRegistrationEntity authenticatedUser = RegistrationImpl.authenticate(resturentRegistrationModel);

		String jwtToken = jwtService.generateToken(authenticatedUser);
		LoginResponce loginResponse = new LoginResponce();
		loginResponse.setToken(jwtToken);
		loginResponse.setExpiresIn(jwtService.getExpirationTime());
		loginResponse.setUserName(authenticatedUser.getOwnerName());

		return loginResponse;
	}
}
