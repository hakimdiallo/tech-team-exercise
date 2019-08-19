package com.soul.backend.tech.team.exercise.services;

import java.util.List;
import java.util.Set;

import com.soul.backend.tech.team.exercise.model.dto.Product;
/**
 * 
 * @author soudiall
 *
 */
public interface IProductService {

  /**
   * Reucpere tous les products
   * @return liste de tous les products
   */
  List<Product> getProducts();

  /**
   * Reucpere tous les products d'un id
   * @param id du product
   * @return liste de tous les products
   */
  List<Product> getProduct(int id);
	
  /**
   * Reucpere tous les id de products
   * @return liste de tous les id
   */
  Set<Integer> getProductIds();
	
}
