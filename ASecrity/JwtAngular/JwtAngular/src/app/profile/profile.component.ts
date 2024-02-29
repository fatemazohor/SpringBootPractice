import { Component, OnInit } from '@angular/core';
import { StorageService } from '../service/storage.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent implements OnInit{

  ngOnInit(): void {
   this.currentUser=this.storageService.getUser();
  }

  currentUser:any


  constructor(private storageService:StorageService){}

}