import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { BookModel } from '../interface/book.model';

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

   addNewbook(book:BookModel):Observable<BookModel>{
    return this.http.post<BookModel>(this.baseUrl,book);
   }

   saveBook(data:any){
    return this.http.post<any>(this.baseUrl,data)
    .pipe(map(res=>{return res}))
   }

   editBook(id:number,data:any){
    return this.http.put<any>(this.baseUrl+ '/' +id,data);
   }

   deleteBook(id:number){
    return this.http.delete<any>(this.baseUrl+'/'+id)
    .pipe(map(res=>{return res}))
   }


}
