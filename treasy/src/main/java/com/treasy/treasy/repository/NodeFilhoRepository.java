package com.treasy.treasy.repository;

import com.treasy.treasy.models.NodeFilho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeFilhoRepository extends JpaRepository<NodeFilho , Integer > {


}
