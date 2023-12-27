import { OrderDetail } from './purchaseOrderDetail';

export interface PurchaseOrder {
  idPurchaseOrder: string;
  dateIssue: Date;
  dateDelivery: Date;
  recepcion: string;
 // supplier: string;
  orderDetails: OrderDetail[]; // Array de detalles de la orden
  total: number;
  status: boolean;
}

/* export interface PurchaseOrder {
  idPurchaseOrder: string;
  dateIssue: Date;
  dateDelivery: Date;
  recepcion: string;
  supplier: string;
  product: string;
  unitProduct: number;
  total: number; //revisar como voy a tomar el precio
  status: boolean
}
 */
