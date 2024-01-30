export interface PurchaseOrder {
  idPurchaseOrder: number;
  dateIssue: Date | string;
  dateDelivery: Date | string;
  recepcion: string;
  supplier: string;
  products: DetailProducts[];
  total: number;
  status: string;
}

export interface DetailProducts {
  idProduct?: string;
  nameProduct: string;
  priceProduct: number;
  unitProduct: number;
}
