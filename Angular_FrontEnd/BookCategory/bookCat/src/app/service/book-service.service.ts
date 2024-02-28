import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book, ProductImage } from '../model/book.model';
import { json } from 'stream/consumers';

@Injectable({
  providedIn: 'root'
})
export class BookServiceService {

  baseUrl='http://localhost:8086/api/book'
  productUrl='http://localhost:8086/api'

  constructor(private http:HttpClient) { }


  getAllBook():Observable<Book[]>{
    return this.http.get<Book[]>(this.baseUrl)
  }

  createBook(book:Book):Observable<Book>{
    return this.http.post<Book>(this.baseUrl,book)
  }

  updateBook(id:number,book:Book):Observable<Book>{
    return this.http.put<Book>(`${this.baseUrl}/${id}`,book);

  }

  // deleteBook(id:number):Observable<Book>{
  //   return this.http.delete<Book>(`${this.baseUrl}/${id}`)
  // }
  deleteBook(id:number):Observable<void>{
    return this.http.delete<void>(this.baseUrl+'/'+id);
  }
  // create product image
  createProduct(product:FormData):Observable<ProductImage>{
  return this.http.post<ProductImage>(`${this.productUrl}/product`,product)
  }
  
  
}
