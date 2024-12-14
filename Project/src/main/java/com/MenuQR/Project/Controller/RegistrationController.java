
package com.MenuQR.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MenuQR.Project.Dao.ResturentRegistrationDaoImpl;
import com.MenuQR.Project.Model.ResturentRegistrationModel;
import com.MenuQR.Project.Model.StatusModel;
import com.MenuQR.Project.Util.RequestValidation;

@RestController
public class RegistrationController {

	@Autowired
	private ResturentRegistrationDaoImpl RegistrationImpl;

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
}
