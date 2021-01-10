package com.allait.soap.dataJpa.repository;

import com.allait.soap.dataJpa.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position,Long> {

//    List<com.allait.soap.gen.Position> findAllSoap(List<Position> list);
}
