export interface PurchaseOrder {
  idPurchaseOrder: string;
  dateIssue: Date;
  dateDelivery: Date;
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

