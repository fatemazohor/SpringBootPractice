import { CategoryModel } from "./category.model";
export class BookModel{
    id?:number;
    name?:string;
    price?:string;
    categoryId?: {
        id: number,
        cateName: string
      }
    
}