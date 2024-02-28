import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  user_key = 'AUTHORIZATION';

  constructor() { }


  public saveUser(user:any){
    window.sessionStorage.removeItem(this.user_key);
    window.sessionStorage.setItem(this.user_key, JSON.stringify(user));
  }

  public getUser():any{
    const user = window.sessionStorage.getItem(this.user_key);
    if(user){
      return JSON.parse(user)
    }
    return {};
  }

  public isLoggedIn():boolean{
    const user = window.sessionStorage.getItem(this.user_key);

    if(user){
      return true;
    }
    return false;
  }
  
}
