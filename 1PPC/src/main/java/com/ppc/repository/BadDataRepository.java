package com.ppc.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.ppc.domain.BadData;

@Repository
public interface BadDataRepository extends CassandraRepository<BadData, Integer> {

}
