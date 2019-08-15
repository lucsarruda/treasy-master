package com.treasy.treasy.repository;

import com.treasy.treasy.models.Nodes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.EventObject;

public interface NodeRepository extends JpaRepository< Nodes, Integer> {

}
