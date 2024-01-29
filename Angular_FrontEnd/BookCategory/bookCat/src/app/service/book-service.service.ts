import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../model/book.model';

@Injectable({
  providedIn: 'root'
})
export class BookServiceService {

  baseUrl='http://localhost:8086/api/book'

  constructor(private http:HttpClient) { }


  getAllBook():Observable<Book[]>{
    return this.http.get<Book[]>(this.baseUrl)
  }

  createBook(book:Book):Observable<Book>{
    return this.http.post<Book>(this.baseUrl,book)
  }
  
}
