package com.bizns.batch.batch.repository;

import com.bizns.batch.batch.entity.ComCodeMst;
import com.bizns.batch.batch.entity.ComCodeMstId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ComCodeMstRepository extends JpaRepository<ComCodeMst, ComCodeMstId> {

}
