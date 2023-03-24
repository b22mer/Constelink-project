package com.srp.constelinkbeneficiary.db.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.srp.constelinkbeneficiary.db.entity.RecoveryDiary;

public interface RecoveryDiaryRepository extends JpaRepository<RecoveryDiary, Long> {
	Page<RecoveryDiary> findAll(Pageable pageable);

	Page<RecoveryDiary> getRecoveryDiariesByBeneficiaryId(Long id, Pageable pageable);
}
