import { Supplier } from '../Models/supplier';

export const supplierData: Supplier[] = [
  /*   {
    urlLogo: '',
    idSupplier: 1,
    codeSupplier: '1234',
    nameSupplier: 'Gaseosa SRL',
    cuitSupplier: '30717055041',
    condicionAfipSupplier: ''
    categorySupplier: ''
    streetSupplier: 'Calle Inventada',
    numSupplier: 1234,
    cpSupplier: 5000,
    locationSupplier: 'Cordoba',
    provinceSupplier: 'Cordoba',
    countrySupplier: 'Argentina',
    webSupplier: 'http://GaseosaSRL.com',
    emailSupplier: 'administracion@GaseosaSRL.com',
    telSupplier: '3513552369',
    namecontactSupplier: 'Juana',
    lastNamecontactSupplier: 'Gomez',
    telcontactSupplier: '3513578987',
    emailcontactSupplier: 'juanagomez@GaseosaSRL.com',
    rolcontactSupplier: 'Administracion',
  },
  {
    urlLogo: '',
    idSupplier: 1,
    codeSupplier: '1234',
    nameSupplier: 'Pepito Juarez',
    cuitSupplier: '203535264831',
    condicionAfipSupplier: ''
    categorySupplier: ''
    streetSupplier: 'Calle Inventada',
    numSupplier: 2214,
    cpSupplier: 5020,
    locationSupplier: 'Cordoba',
    provinceSupplier: 'Córdoba',
    countrySupplier: 'Argentina',
    webSupplier: '',
    emailSupplier: 'pepitoJuarez@gmail.com',
    telSupplier: '3513552740',
    namecontactSupplier: 'Maria',
    lastNamecontactSupplier: 'Gomez',
    telcontactSupplier: '3513566887',
    emailcontactSupplier: 'marigomez@gmail.com',
    rolcontactSupplier: 'Administracion',
  },
  {
    urlLogo:
      'data:image/jpeg;base64,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',
    idSupplier: 1,
    codeSupplier: '1234',
    nameSupplier: 'Arcor SA',
    cuitSupplier: '30502793175',
    condicionAfipSupplier: ''
    categorySupplier: ''
    streetSupplier: 'Av. Fulvio S. Pagani',
    numSupplier: 487,
    cpSupplier: 5000,
    locationSupplier: 'Arroyito',
    provinceSupplier: 'Cordoba',
    countrySupplier: 'Argentina',
    webSupplier: 'http://arcor.com',
    emailSupplier: 'arcoradmi@arcor.com',
    telSupplier: '3513552740',
    namecontactSupplier: 'Tomas',
    lastNamecontactSupplier: 'Perez',
    telcontactSupplier: '3513566887',
    emailcontactSupplier: 'tperez@arcor.com',
    rolcontactSupplier: 'Gerente',
  },
  {
    urlLogo:
      'data:image/jpeg;base64,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',
    idSupplier: 1,
    codeSupplier: '1234',
    nameSupplier: 'Coca Cola SA',
    cuitSupplier: '30525390086',
    condicionAfipSupplier: '',
    categorySupplier: '',
    streetSupplier: 'Alcorta amancio',
    numSupplier: 3506,
    cpSupplier: 4000,
    locationSupplier: 'Ciudad Autonoma',
    provinceSupplier: 'Buenos Aires',
    countrySupplier: 'Argentina',
    webSupplier: 'http://coca-cola.com',
    emailSupplier: 'cocacoladmi@cocacola.com',
    telSupplier: '3513552740',
    namecontactSupplier: 'Julia',
    lastNamecontactSupplier: 'Perez',
    telcontactSupplier: '3513566887',
    emailcontactSupplier: 'jperez@cocacola.com',
    rolcontactSupplier: 'Gerente',
  }, */
];
