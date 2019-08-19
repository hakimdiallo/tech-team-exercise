package com.soul.backend.tech.team.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.soul.backend.tech.team.exercise.model.dto.Product;
import com.soul.backend.tech.team.exercise.services.IProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ProductServiceTest {
  
  @Autowired
  private IProductService productService;
  
  @Test
  public void testGetAllProducts() {
    List<Product> products = productService.getProducts();
    assertNotNull(products);
    assertEquals(100, products.size());
  }
  
  @Test
  public void testgetAllProductIds() {
    Set<Integer> ids = productService.getProductIds();
    assertNotNull(ids);
    assertEquals(17, ids.size());
  }
  
  @Test
  public void testGetProductById() {
    List<Product> products = productService.getProduct(-1);
    assertNotNull(products);
    assertEquals(0, products.size());
    
    products = productService.getProduct(1);
    assertNotNull(products);
    assertEquals(6, products.size());
  }

}
