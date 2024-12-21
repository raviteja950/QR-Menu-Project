package com.MenuQR.Project.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MenuQR.Project.Entity.ResturentRegistrationEntity;
import com.MenuQR.Project.Model.ResturentRegistrationModel;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@SuppressWarnings("unused")
public class ResturentRegistrationDaoImpl {

	@Autowired
	private ResturentRegistartionDao RegistrationDao;

	private final PasswordEncoder passwordEncoder;

	private final AuthenticationManager authenticationManager;

	public ResturentRegistrationDaoImpl(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
	}

	public ResturentRegistrationModel saveResturantDetails(ResturentRegistrationModel registationRequest) {
		ResturentRegistrationEntity resturentEntity = new ResturentRegistrationEntity();
		resturentEntity.setEmail(registationRequest.getEmail());
		resturentEntity.setPassword(passwordEncoder.encode(registationRequest.getPassword()));
		resturentEntity.setResturentName(registationRequest.getResturentName());
		resturentEntity.setAddress(registationRequest.getAddress());
		resturentEntity.setCity(registationRequest.getCity());
		resturentEntity.setZipCode(registationRequest.getZipCode());
		resturentEntity.setNumber(registationRequest.getNumber());
		resturentEntity.setOwnerName(registationRequest.getOwnerName());
		RegistrationDao.save(resturentEntity);
		return registationRequest;
	}

	public ResturentRegistrationEntity authenticate(ResturentRegistrationModel input) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));

		return RegistrationDao.findByEmail(input.getEmail()).orElseThrow();
	}

	public List<ResturentRegistrationEntity> fetchAllResturentDetails() {
		return RegistrationDao.findAll();
	}

}
