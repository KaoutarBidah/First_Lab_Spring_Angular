import { Component, OnInit } from '@angular/core';
import { CatalogueService } from '../catalogue.service';
import { ActivatedRoute, NavigationEnd, Route, Router } from '@angular/router';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
})
export class ProductsComponent implements OnInit {
  public products;

  constructor(
    public catalogueService: CatalogueService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.router.events.subscribe((value) => {
      if (value instanceof NavigationEnd) {
        let url = value.url;
        console.log(url);
      }

      let p1 = this.route.snapshot.params['p1'];
      if(p1==1){
        this.getProducts("/products/search/selectedProducts");
      }else if(p1==2){
        let idCat = this.route.snapshot.params['p2'];
        this.getProducts("/categories/"+idCat+"/products");
      }
    });

    let p1 = this.route.snapshot.params['p1'];
    if(p1==1){
      this.getProducts("/products/search/selectedProducts")
    }
  }

  getProducts(url) {
    this.catalogueService
      .getResource(url)
      .subscribe(
        (data) => {
          this.products = data;
        },
        (error) => {
          console.log(error);
        }
      );
  }
}
