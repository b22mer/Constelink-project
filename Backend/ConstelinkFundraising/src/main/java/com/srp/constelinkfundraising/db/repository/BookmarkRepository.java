package com.srp.constelinkfundraising.db.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.srp.constelinkfundraising.db.entity.Bookmark;
import com.srp.constelinkfundraising.db.entity.BookmarkId;
import com.srp.constelinkfundraising.db.entity.Fundraising;

public interface BookmarkRepository extends JpaRepository<Bookmark, BookmarkId> {

	Bookmark findBookmarksById(BookmarkId bookmarkId);
	Page<Bookmark> findBookmarksByIdMemberId(Long memberId, Pageable pageable);
	Bookmark findBookmarkByIdMemberId(Long memberId);
}
