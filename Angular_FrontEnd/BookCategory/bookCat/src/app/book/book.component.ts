import { Component, OnInit } from '@angular/core';
import { Book } from '../model/book.model';
import { Category } from '../model/category.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BookServiceService } from '../service/book-service.service';
import { CategoryServiceService } from '../service/category-service.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrl: './book.component.css'
})
export class BookComponent implements OnInit{

  book:Book[]=[];
  category:Category[]=[];
  bookForm!:FormGroup

  constructor(
    private bookService:BookServiceService,
    private categoryService:CategoryServiceService,
    private formBulder:FormBuilder
  ){
    
  }

  
  ngOnInit(): void {
    this.initBookForm();
    this.loadBook();
    this.loadCategory();
    
  }


  initBookForm(){
    this.bookForm=this.formBulder.group({
      name:['',Validators.required],
      price:['',Validators.required],
      categoryId:['',Validators.required]
    })
  }


  loadBook(){
    this.bookService.getAllBook().subscribe({
      next:res=>{
        this.book=res
      },
      error:err=>{
        console.error('error',err);
      }
    })
  }

  loadCategory(){
    this.categoryService.getAllCategory().subscribe({
      next:res=>{
        this.category=res
        console.log(this.category);
      },
      error:err=>{
        console.error('error',err);
      }
    })
  }

onSubmit(){
  if(this.bookForm.valid){
    const bookData:Book = this.bookForm.value;
    this.bookService.createBook(bookData).subscribe({
      next:res=>{
        console.log('book saved',res);
        alert('Book saved')
        this.loadBook();
        this.bookForm.reset();
      },
      error:err=>{
        alert('Book not saved')
      }
    })
  }
}




}
