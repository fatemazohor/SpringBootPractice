import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{

  image?:any;
  image2?:String="../../../../../ava/image (1).png"
  constructor(
    private serv:ServiceService,

  ){}
  ngOnInit(): void {
    this.serv.getImageUrl().subscribe({
      next:res=>{
        this.image=res;
      },
      error:err=>{
        console.log(err)
        console.log("--------------- image not found --------------.")
      }
    })
  }

}
