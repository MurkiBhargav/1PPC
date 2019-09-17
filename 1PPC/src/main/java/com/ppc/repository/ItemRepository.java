package com.ppc.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.ppc.domain.Item;

@Repository
public interface ItemRepository extends CassandraRepository<Item, Integer> {

}
