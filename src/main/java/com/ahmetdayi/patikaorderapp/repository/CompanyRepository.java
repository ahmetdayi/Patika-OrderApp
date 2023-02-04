package com.ahmetdayi.patikaorderapp.repository;

import com.ahmetdayi.patikaorderapp.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
}
