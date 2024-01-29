import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Category } from '../model/category.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryServiceService {

  baseUrl='http://localhost:8086/api/cate'

  constructor(private http:HttpClient) { }


  getAllCategory():Observable<Category[]>{
    return this.http.get<Category[]>(this.baseUrl)
  }

  createCategory(book:Category):Observable<Category>{
    return this.http.post<Category>(this.baseUrl,book)
  }
}
