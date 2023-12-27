export interface OrderDetail {
  product: string;
  unitProduct: number;
  total: number;
  supplier: {
    name: string;
    products: string[];
  };
}
