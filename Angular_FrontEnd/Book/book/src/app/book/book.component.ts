import { Component, OnInit } from '@angular/core';
import { BookModel } from '../interface/book.model';
import { FormBuilder, FormGroup } from '@angular/forms';
import { BookService } from '../service/book.service';
import { error } from 'console';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrl: './book.component.css'
})
export class BookComponent implements OnInit{

  bookModel:BookModel=new BookModel()
  formValue !:FormGroup
  bookData:any

  constructor(private api:BookService,private formBuilder:FormBuilder){}
  ngOnInit(): void {
    this.formValue=this.formBuilder.group({
      name:[''],
      price:['']
    })
    this.getBook();
    
  }

  getBook(){
    this.api.getAllBook().subscribe({
      next:res=>{this.bookData=res}
    })
  }

addBook(){
  this.bookModel.name=this.formValue.value.name;
  this.bookModel.price=this.formValue.value.price;
  // this.bookData.name=this.formValue.value.name;
  this.api.saveBook(this.bookModel)
  .subscribe(res=>
    {console.log(res)
    alert('Data saved')
    this.formValue.reset();
    this.getBook()
    },
    erro=>{
      alert("Data not saved");
    }
    )
}
editById(bo:any){
  this.bookModel.id=bo.id
  this.formValue.controls['name'].setValue(bo.name)
  this.formValue.controls['price'].setValue(bo.price)
}

updateBook(){
  this.bookModel.name=this.formValue.value.name;
  this.bookModel.price=this.formValue.value.price;

  this.api.editBook(this.bookModel.id,this.bookModel)
  .subscribe({next:res=>{
    console.log(res)
    alert("Data updated")
    this.getBook();
  },
  error:err=>
  {alert("Data not updated")}
})
}

deleteBooks(bo:any){
  this.api.deleteBook(bo.id)
  .subscribe({next:res=>{
    console.log(res)
    alert("Data deletd")
    this.getBook()
  },
error: err=>{
  console.log(err)
  alert("data not deleted")
}})
}

}
