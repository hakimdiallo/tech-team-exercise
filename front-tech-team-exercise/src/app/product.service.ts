import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/api/';
  constructor(private httpClient: HttpClient) { }

  public getAllProduct() {
    return this.httpClient.get<Product[]>(this.baseUrl + 'products');
  }

  public getProductIds() {
    return this.httpClient.get(this.baseUrl + 'productIds');
  }

  public getProductById(id) {
    return this.httpClient.get<Product[]>(this.baseUrl + 'product/' + id);
  }
}
