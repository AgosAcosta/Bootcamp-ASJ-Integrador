export interface Supplier {
  urlLogo?: string;
  idSupplier: number;
  codeSupplier: string;
  nameSupplier: string;
  cuitSupplier: string;
  condicionAfipSupplier: String;
  categorySupplier: String;
  streetSupplier: string;
  numSupplier: number;
  cpSupplier: number;
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

export interface CategorySupplier {
  idCategorySupplier: number;
  categorySupplier: string;
}

export interface ConditionAfip {
  idConditionAfip: number;
  conditionAfip: string;
}

export interface Country {
  idCountry: number;
  country: string;
}

export interface Provinces {
  idProvince: number;
  country: string;
  province: string;
}
