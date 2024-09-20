package com.koo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koo.domain.BadgeCard;

public interface BadgeCardRepository extends JpaRepository<BadgeCard, Long>{
	List<BadgeCard> findByUserIdOrderByBadgeTimestampDesc(final Long userId);

}
