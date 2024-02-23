import { SafeUrl } from "@angular/platform-browser";

export class Book{
    id:number=0;
    name?:string;
    price?:string;
    categoryId?:{
        id:number;
        cateName:string
    }
}
export class ProductImage{
    id:number=0
    pname?:string
    pDescription?:string
    pImage?:FileHandle
}
export interface FileHandle{
    previewFile:File,
    url:SafeUrl
}