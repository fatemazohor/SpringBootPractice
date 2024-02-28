import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  api_url = "http://localhost:8085/"

  constructor(private http:HttpClient) { }

  getPublicContent():Observable<any>{
    return this.http.get(`${this.api_url}demo`, {responseType:'text'});
  }
  getAdminContent():Observable<any>{
    return this.http.get(`${this.api_url}admin`, {responseType:'text'});
  }
}
