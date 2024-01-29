import { CategoryModel } from "./category.model";
export class BookModel{
    id:number=0;
    name?:string;
    price?:string;
    categoryId?: {
        id: number,
        cateName: string
      }
    
}