package com.ahmetdayi.patikaorderapp.repository;

import com.ahmetdayi.patikaorderapp.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BillRepository extends JpaRepository<Bill, UUID> {
}
