export interface Product {
  idProduct: number;
  urlLogo?: string;
  codeProduct: string;
  categoryProduct: string;
  nameProduct: string;
  descriptionProduct: string;
  priceProduct: number;
  supplierName: string;
}

export interface CategoryProduct {
  idCategoryProduct: number;
  categoryProduct: string;
}
