export interface IDevice {
  id:number,
  brand:string,
  description:string,
  shortName:string,
  type:string,
  inventoryNo:string | null,
  belongsto:IDevice,
  category:ICategory
}

export interface ICategory {
  abbr:string,
  name:string
}
