package com.hcycom.ctginms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcycom.ctginms.domain.LinkInfo;

@Repository
public interface LinkInfoRepository extends JpaRepository<LinkInfo, String> {
	public List<LinkInfo> findByLinkcategory(Integer category);
}
