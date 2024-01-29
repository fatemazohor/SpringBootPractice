import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CategoryModel } from '../interface/category.model';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  baseUrl:string='http://localhost:8086/api/cate';

  constructor(private http:HttpClient) { }

  getAllCategory():Observable<CategoryModel[]>{
    return this.http.get<CategoryModel[]>(this.baseUrl);
  }

  createCategory(category:CategoryModel):Observable<CategoryModel>{
    return this.http.post<CategoryModel>(this.baseUrl,category);
  }

  updateCatetgory(id:number,category:CategoryModel):Observable<CategoryModel>{
    return this.http.put<CategoryModel>(`${this.baseUrl}/${id}`,category);
  }

  deleteCategory(id:number):Observable<CategoryModel>{
    return this.http.delete<CategoryModel>(`${this.baseUrl}/${id}`);
  }
  





}
