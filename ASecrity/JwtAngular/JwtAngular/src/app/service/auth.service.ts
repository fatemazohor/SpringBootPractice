import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  httpOptions = {
    headers: new HttpHeaders({ 'Conten-Type': 'application/json' })
  }

  AUTH_API = "http://localhost:8080/"

  constructor(private http: HttpClient) { }

  login(email: string, password: string): Observable<any> {

    return this.http.post(this.AUTH_API + "login", { email, password }, this.httpOptions);

  }


  register(name: string, email: string, password: string, role: string): Observable<any> {

    return this.http.post(this.AUTH_API + "register", { name, email, password, role }, this.httpOptions);
  }

  logout(): Observable<any> {
    
    return this.http.post(this.AUTH_API + "logout", {}, this.httpOptions);
  }

}
