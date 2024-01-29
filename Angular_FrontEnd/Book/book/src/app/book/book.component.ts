import { Component, OnInit } from '@angular/core';
import { BookModel } from '../interface/book.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BookService } from '../service/book.service';
import { error } from 'console';
import { CategoryService } from '../service/category.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrl: './book.component.css'
})
export class BookComponent implements OnInit{

  bookModel:BookModel=new BookModel();
  books:BookModel[]=[]
  formValue !:FormGroup
  bookData:any
  cateData:any

  constructor(
    private api:BookService,
    private formBuilder:FormBuilder,
    private cateApi:CategoryService){}
  ngOnInit(): void {
    this.initFormValue();
    this.getBook();
    this.getCategory();
    
  }
  initFormValue(){
    this.formValue=this.formBuilder.group({
      name:['', Validators.required],
      price:['',Validators.required],
      categoryId:['',Validators.required]
    })
  }

  getCategory(){
    this.cateApi.getAllCategory().subscribe({
      next:res=>{this.cateData=res},
      error:err=>{
        console.error('error fetching data',err)
      }
    })
  }

  getBook(){
    this.api.getAllBook().subscribe({
      next:res=>{this.bookData=res},
      error:error => console.error('Error fetching employees', error)
    })
  }

  onSubmit(){
    if(this.formValue.valid){
      const bookModelData:BookModel=this.formValue.value;
      this.api.saveBook(bookModelData).subscribe({
        next:res=>{
          console.log('Book created')
          this.getBook();
          this.formValue.reset();
          alert('Book is saved')
        },
        error:err=>{
          alert('Book not saved');
        }
      })
    }
  }

addBook(){
  // this.bookModel.name=this.formValue.value.name;
  // this.bookModel.price=this.formValue.value.price;
  // this.bookData.name=this.formValue.value.name;
  if(this.formValue.valid){
    this.bookModel.name=this.formValue.value.name;
  this.bookModel.price=this.formValue.value.price;
  this.bookModel.categoryId=this.formValue.value.categoryId;
  this.api.saveBook(this.bookModel)
  .subscribe(res=>
    {console.log(res);
    
    alert('Data saved');
    this.getBook()
    this.formValue.reset();
    },
    erro=>{
      alert("Data not saved");
    })

  }
  
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
    alert("Data deleted")
    this.getBook()
  },
  error: err=>{
  console.log(err)
  alert("data not deleted")
}
})
}

}
