package com.MenuQR.Project.Util;

import com.MenuQR.Project.Model.ResturentRegistrationModel;
import com.MenuQR.Project.Model.StatusModel;

public class RequestValidation {

	public StatusModel registrationValidation(ResturentRegistrationModel request) {

		StatusModel responce = new StatusModel();

		if (request.getEmail() == null || request.getPassword() == null || request.getResturentName() == null
				|| request.getAddress() == null || request.getCity() == null || request.getZipCode() == null
				|| request.getNumber() == null || request.getOwnerName() == null) {

			responce.setCode(400);
			responce.setMessage(
					"email, password ,resturentName, address,city, zipCode ,Number,ownerName are missing. this all are mandatory fields!!");
		} else {
			responce.setCode(200);
			responce.setMessage("requestValidated Sucessfully");
		}

		return responce;

	}
}
