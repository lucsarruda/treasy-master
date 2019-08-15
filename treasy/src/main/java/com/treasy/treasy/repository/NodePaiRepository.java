package com.treasy.treasy.repository;

import com.treasy.treasy.models.NodePai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodePaiRepository extends JpaRepository<NodePai, Integer> {


}
