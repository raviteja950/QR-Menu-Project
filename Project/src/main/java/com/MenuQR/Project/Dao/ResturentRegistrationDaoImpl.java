package com.MenuQR.Project.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MenuQR.Project.Entity.ResturentRegistrationEntity;
import com.MenuQR.Project.Model.ResturentRegistrationModel;

@Service
public class ResturentRegistrationDaoImpl {

	@Autowired
	private ResturentRegistartionDao RegistrationDao;

	public ResturentRegistrationModel saveResturantDetails(ResturentRegistrationModel registationRequest) {

		ResturentRegistrationEntity resturentEntity = new ResturentRegistrationEntity();
		resturentEntity.setEmail(registationRequest.getEmail());
		resturentEntity.setPassword(registationRequest.getPassword());
		resturentEntity.setResturentName(registationRequest.getResturentName());
		resturentEntity.setAddress(registationRequest.getAddress());
		resturentEntity.setCity(registationRequest.getCity());
		resturentEntity.setZipCode(registationRequest.getZipCode());
		resturentEntity.setNumber(registationRequest.getNumber());
		resturentEntity.setOwnerName(registationRequest.getOwnerName());

		RegistrationDao.save(resturentEntity);
		return registationRequest;

	}

}
