package com.ppc.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.ppc.domain.ItemPromo;

@Repository
public interface ItemPromoRepository extends CassandraRepository<ItemPromo, Integer> {

}
