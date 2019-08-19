import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { Chart } from 'chart.js';
import { ProductService } from '../product.service';
import { Product } from '../product';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  @ViewChild('toto') canvas: ElementRef;

  public productIds: any;
  public products: Product[];
  public filteredProducts: Product[];
  public inventoryLevel: any;
  public dateProduct: any;
  public linechart: any;

  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.productService.getProductIds().subscribe(data => {
      if (data) {
        this.productIds = data;
      }
    });
    this.dateProduct = [];
    this.inventoryLevel = [];
  }

  /**
   * Permet de recupere les produit à partir de son id
   * @param id du produit a recupere
   */
  showProduct(id) {
    if (id) {
      this.productService.getProductById(id).subscribe(data => {
        if (data) {
          this.sort(data);
          this.filteredProducts = data;
          this.dateProduct = [];
          this.inventoryLevel = [];
          this.linechart = undefined;
          this.filteredProducts.forEach(p => {
            this.dateProduct.push(p.date);
            this.inventoryLevel.push(p.inventoryLevel);
            this.createChart('line');
          });
        }
       });
    } else {
      this.filteredProducts = undefined;
      this.linechart.clear();
      this.dateProduct = [];
      this.inventoryLevel = [];
    }
  }

  /**
   * permet de trier une liste de produits à partir de la date
   * @param data liste des products
   */
  private sort(data) {
    data.sort((a, b) => {
      return new Date( this.formatDate(a.date)).getTime() - new Date( this.formatDate(b.date)).getTime();
    });
  }

  /**
   * Permet de formater une date dd-mm-yyyy en mm-dd-yy qui
   * est le format accepté par Date()
   * @param date date à formater
   */
  private formatDate(date: string) {
    const format = date.split('-');
    return format[1] + '-' + format[0] + '-' + format[2];
  }

  /**
   * Permert de creer un Chart
   */
  public createChart(type: string) {
    this.linechart = new Chart(this.canvas.nativeElement.getContext('2d'), {
      type: type,
      data: {
        labels: this.dateProduct,

        datasets: [
          {
            data: this.inventoryLevel,
            borderColor: '#3cb371',
            backgroundColor: '#0000FF',
          }
        ]
      },
      options: {
        legend: {
          display: false
        },
        scales: {
          xAxes: [{
            display: true
          }],
          yAxes: [{
            display: true
          }],
        },
        events: []
      }
    });
  }
}
