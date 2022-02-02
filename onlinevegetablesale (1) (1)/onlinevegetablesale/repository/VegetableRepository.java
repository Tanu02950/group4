package com.siri.proj.java.onlinevegetablesale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siri.proj.java.onlinevegetablesale.entity.Vegetable;

@Repository
public interface VegetableRepository extends JpaRepository<Vegetable, Integer> {

}
