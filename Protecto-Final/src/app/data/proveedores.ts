/* export const proveedor = [
  {
    id: 1,
    razonSocial: 'Proveedor 1',
    cuit: '12345678901',
    condicionAfip: 'Responsable Inscripto',
    rubro: 'Alimenticio',
  },
  {
    id: 2,
    razonSocial: 'Proveedor 2',
    cuit: '98765432109',
    condicionAfip: 'Monotributista',
    rubro: 'Tecnologico',
  },
  {
    id: 3,
    razonSocial: 'Pepito Juarez',
    cuit: '123456789',
    condicionAfip: 'Consumidor Final',
    rubro: 'Insumos',
  },
]; */

export interface Supplier {
  idSupplier?: undefined;
  nameSupplier: string;
  cuitSupplier: string;
  condicionAfipSupplier: string;
  categorySupplier: string;
  streetSupplier: string;
  numSupplier: undefined;
  cpSupplier: undefined;
  locationSupplier: string;
  provinceSupplier: string;
  countrySupplier: string;
  webSupplier: string;
  emailSupplier: string;
  telSupplier: string;
  namecontactSupplier: string;
  lastNamecontactSupplier: string;
  telcontactSupplier: string;
  emailcontactSupplier: string;
  rolcontactSupplier: string;
}
