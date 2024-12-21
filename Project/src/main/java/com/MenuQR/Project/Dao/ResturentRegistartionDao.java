package com.MenuQR.Project.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MenuQR.Project.Entity.ResturentRegistrationEntity;

@Repository
public interface ResturentRegistartionDao extends JpaRepository<ResturentRegistrationEntity, Long> {

	Optional<ResturentRegistrationEntity> findByEmail(String email);

}
