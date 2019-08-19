package com.soul.backend.tech.team.exercise.dao;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import com.soul.backend.tech.team.exercise.model.entities.ProductEntity;

/**
 * 
 * @author soudiall
 *
 */
@Service(value="productDao")
public class ProductDao {
	
    private static final String FILE_NAME = "jdd.xls";
	
	private List<ProductEntity> products = new ArrayList<ProductEntity>();
	private Set<Integer> ids = new HashSet<Integer>();
	
	public ProductDao() {
		
	}
	
	private void loadFile() {
	    this.products = new ArrayList<>();
	    this.ids = new HashSet<>();
		try {
			File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new HSSFWorkbook(fileInputStream);
	        Sheet datatypeSheet = workbook.getSheetAt(0);
	        Iterator<Row> iterator = datatypeSheet.iterator();
	
	        while (iterator.hasNext()) {
	            Row currentRow = iterator.next();
	            if (currentRow.getRowNum() > 0 && currentRow.getRowNum() < 102) {
	            	Iterator<Cell> cellIterator = currentRow.iterator();
	            	ProductEntity productEntity = new ProductEntity();
	                while (cellIterator.hasNext()) {
	                    Cell currentCell = cellIterator.next();
	                    switch (currentCell.getColumnIndex()) {
                          case 0:
                            productEntity.setId((int)currentCell.getNumericCellValue());
                            break;
                          case 1:
                            productEntity.setName(currentCell.getStringCellValue());
                            break;
                          case 2:
                            productEntity.setDate(currentCell.getStringCellValue());
                            break;
                          case 3:
                            productEntity.setInventoryLevel((int)currentCell.getNumericCellValue());
                            break;
                          default:
                            break;
                        }
	                }
	                if (productEntity != null && productEntity.getName() != null) {
	                  products.add(productEntity);
	                  ids.add(productEntity.getId());
                    }
				}
	        }
	        workbook.close();
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}
	
	public List<ProductEntity> getProducts(){
	  this.loadFile();
	  return this.products;
	}
	
	public Set<Integer> getProductIds(){
	  this.loadFile();
	  return this.ids;
	}
	
	public List<ProductEntity> getProducts(int id){
      this.loadFile();
      List<ProductEntity> prods = this.products.stream().filter(p -> p.getId() == id).collect(Collectors.toList());
      return prods;
    }
}
