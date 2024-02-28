import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  httpOption = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  }

  AUTH_API = "http://localhost:8085/"
  constructor(
    private http:HttpClient
  ) { }

  login(email:string, password:string):Observable<any>{

    return this.http.post(`${this.AUTH_API}login`,{email, password}, this.httpOption)
  }

  register(name:string, email:string, password:string, role:string):Observable<any>{

    return this.http.post(`${this.AUTH_API}register` , {name, email, password, role}, this.httpOption)
  }

  logout():Observable<any>{

    return this.http.post(`${this.AUTH_API}logout`, {}, this.httpOption)
  }
}
