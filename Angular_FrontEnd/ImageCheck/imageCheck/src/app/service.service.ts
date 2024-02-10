import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  baseUrl:String="https://www.w3schools.com/howto/img_avatar.png";
  constructor(private http:HttpClient) { }

  getImageUrl(){
    return this.http.get(`${this.baseUrl}`,{responseType: 'text'});
  }
}
