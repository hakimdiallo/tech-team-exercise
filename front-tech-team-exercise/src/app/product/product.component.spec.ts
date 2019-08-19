import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductComponent } from './product.component';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { ProductService } from '../product.service';
import { ProductServiceStub } from '../service-testing';

describe('ProductComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductComponent ],
      providers: [
        {provide: ProductService, useClass: ProductServiceStub }
      ],
      schemas: [ NO_ERRORS_SCHEMA]
    })
    .compileComponents();

    this.fixture = TestBed.createComponent(ProductComponent);
    this.component = this.fixture.componentInstance;

  }));

  it('should create', () => {
    expect(this.component).toBeTruthy();
  });

  describe('.formatDate(:date)', () => {
    it('should return newformatDate mm-dd-yyyy', () => {
      // Given
      const date = "25-12-2018";

      // When
      const result = this.component.formatDate(date);

      // Then
      expect(result).toEqual("12-25-2018");

    });
  });
});
