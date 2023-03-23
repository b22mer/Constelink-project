package com.srp.constelinkbeneficiary.db.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.srp.constelinkbeneficiary.db.dto.enums.HospitalSortType;
import com.srp.constelinkbeneficiary.db.dto.enums.RecoveryDiarySortType;
import com.srp.constelinkbeneficiary.db.dto.request.RecoveryDiaryRequest;
import com.srp.constelinkbeneficiary.db.dto.response.RecoveryDiaryResponse;
import com.srp.constelinkbeneficiary.db.service.RecoveryDiaryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "회복일지 API", description = "회복일지 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recoverydiaries")
public class RecoveryDiaryController {
	private final RecoveryDiaryService recoveryDiaryService;

	@Operation(summary = "회복일지 목록 조회", description = "page, size, sort_by 값 필요. dafault값 page=1, size=5, sort_by=ID_ASC")
	@GetMapping("")
	public ResponseEntity<Page<RecoveryDiaryResponse>> getRecoveryDiaries(
		@RequestParam(value = "page", required = false, defaultValue = "1") int page,
		@RequestParam(value = "size", required = false, defaultValue = "5") int size,
		@RequestParam(value = "sort_by", required = false, defaultValue = "ID_ASC") RecoveryDiarySortType sortType) {
		Page<RecoveryDiaryResponse> recoveryDiaries = recoveryDiaryService.getRecoveryDiaryList(page - 1, size,
			sortType);
		return ResponseEntity.ok(recoveryDiaries);
	}

	@Operation(summary = "회복일지 등록", description = "beneficiaryId, title, content, amountSpent, beneficiaryId 기입")
	@PostMapping("")
	public ResponseEntity<RecoveryDiaryResponse> addRecoveryDiary(
		@RequestBody RecoveryDiaryRequest recoveryDiaryRequest
	) {
		return ResponseEntity.ok(recoveryDiaryService.addRecoveryDiary(recoveryDiaryRequest));
	}

}
