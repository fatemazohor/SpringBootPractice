import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  

  baseUrl:string="http://localhost:8086/api/book";



  constructor(private http:HttpClient) {

   }

   getAllBook(){
    return this.http.get<any>(this.baseUrl)
    .pipe(map(res=>{return res}))
   }

   saveBook(data:any){
    return this.http.post<any>(this.baseUrl,data)
    .pipe(map(res=>{return res}))
   }

   editBook(id:number,data:any){
    return this.http.put<any>(this.baseUrl+ '/' +id,data);
   }

   deleteBook(id:number){
    return this.http.delete<any>(this.baseUrl+ '/' +id)
    .pipe(map(res=>{return res}))
   }


}
