package com.soul.backend.tech.team.exercise.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soul.backend.tech.team.exercise.dao.ProductDao;
import com.soul.backend.tech.team.exercise.model.dto.Product;
import com.soul.backend.tech.team.exercise.model.entities.ProductEntity;
import com.soul.backend.tech.team.exercise.services.IProductService;

/**
 * 
 * @author soudiall
 *
 */
@Service(value="productService")
public class ProductServiceImpl implements IProductService {
  
  @Autowired
  private ProductDao productDao;
  
  @Autowired
  private ObjectMapper mapper;

  public List<Product> getProducts() {
	return mapEntityIntoDto(productDao.getProducts());
  }

  public List<Product> getProduct(int id) {
	return mapEntityIntoDto(productDao.getProducts(id));
  }

  public Set<Integer> getProductIds() {
	return productDao.getProductIds();
  }
  
  private List<Product> mapEntityIntoDto(List<ProductEntity> productEntities){
    List<Product> products = new ArrayList<Product>();
    for (ProductEntity product : productEntities) {
      Product p = mapper.convertValue(product, Product.class);
      products.add(p);
    }
    return products;
  }

}
	