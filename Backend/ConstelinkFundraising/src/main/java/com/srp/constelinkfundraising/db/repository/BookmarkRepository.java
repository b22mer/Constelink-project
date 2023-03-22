package com.srp.constelinkfundraising.db.repository;

import java.util.HashSet;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.srp.constelinkfundraising.db.entity.Bookmark;
import com.srp.constelinkfundraising.db.entity.BookmarkId;

public interface BookmarkRepository extends JpaRepository<Bookmark, BookmarkId> {

	Bookmark findBookmarksById(BookmarkId bookmarkId);

	Page<Bookmark> findBookmarksByIdMemberId(Long memberId, Pageable pageable);

	@Query("SELECT u.id.fundraisingId FROM Bookmark u")
	HashSet<Long> findBookmarksByIdMemberId(Long memberId);

	// @Query("SELECT u.id.fundraisingId FROM Bookmark u")
	// HashSet<Long> findBookmarksByIdMemberId(Long memberId, Pageable pageable);

}
