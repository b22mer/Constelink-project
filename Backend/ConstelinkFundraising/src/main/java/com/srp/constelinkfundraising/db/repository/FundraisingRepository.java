package com.srp.constelinkfundraising.db.repository;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.srp.constelinkfundraising.db.entity.Fundraising;

public interface FundraisingRepository extends JpaRepository<Fundraising, Long> {

	@Query(value = "SELECT u FROM Fundraising u join fetch Category c on u.category.id = c.id ",
		countQuery = "SELECT count(u) FROM Fundraising u")
	Page<Fundraising> findAll(Pageable pageable);

	Page<Fundraising> findFundraisingsByFundraisingIsDone(Boolean done, Pageable pageable);

	Page<Fundraising> findFundraisingsByFundraisingIsDoneFalse(Pageable pageable);

	Page<Fundraising> findFundraisingsByBeneficiaryId(Long beneficiary, Pageable pageable);

	Optional<Fundraising> findFundraisingById(Long id);
	// Page<Fundraising> findFundraisingsByFundraisingTitleContaining(String search, Pageable pageable);

	// Page<Fundraising> findFundraisingsByFundraisingEndTimeAfter(Timestamp timestamp, Pageable pageable);

	// Page<Fundraising> findFundraisingsByFundraisingEndTimeBefore(Timestamp timestamp, Pageable pageable);
	HashSet<Fundraising> findFundraisingsByIdIsIn(HashSet<Long> idList);

	@Query("select count(b) as totalFundraisings, (select count(c) from Fundraising c where c.fundraisingIsDone = true) as totalFundraisingsFinished , sum(b.fundraisingAmountRaised) as totalAmountedCash from Fundraising b")
	Map<String, Long> findFundraisingsStatistics();


	@Query("select f from Fundraising f join Category c on f.category.id = c.id  where f.category.id = :categoryId")
	Page<Fundraising> getFundraisingsByCategory_Id(Long categoryId, Pageable pageable);
}
