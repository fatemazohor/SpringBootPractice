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

  // selectedFile: File = null;
  stringValue: string = '';


  book:Book[]=[];
  category:Category[]=[];
  bookForm!:FormGroup
  bookModel:Book = new Book();
  button:number=1;
  

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
      categoryId:['',Validators.required],
      profile:['']
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


deleteBook(bookId:number){
  this.bookService.deleteBook(bookId).subscribe({
    next:res=>{
      console.log('book deleted');
      this.loadBook();
      alert('Book deleted');
      console.log(res);
    },
    error:err=>{
      this.loadBook();
      alert('Book not deleted');
      console.log('book not deleted');
      console.log(err);
    }
  })
 }

onEditById(bo:any){
  this.bookModel.id=bo.id;
  this.bookForm.controls['name'].setValue(bo.name)
  this.bookForm.controls['price'].setValue(bo.price)
  this.bookForm.controls['categoryId'].setValue(bo.categoryId.cateName)
 this.button=2;
}

editBook(){
  if(this.bookForm.valid){
    // this.bookModel=this.bookForm.value
    this.bookModel.name=this.bookForm.value.name
    this.bookModel.price=this.bookForm.value.price
    this.bookModel.categoryId=this.bookForm.value.categoryId;
    // const bookData:Book = this.bookForm.value;
    this.bookService.updateBook(this.bookModel.id,this.bookModel)
    .subscribe({
      next:res=>{
        console.log(res)
        alert("Book is updated")
        this.loadBook()
        this.bookForm.reset()
      },
      error:err=>{
        this.loadBook()
        alert("Book not found for update")
        console.log(err);
      }
    })
  }
}



// onFileSelected(event): void {
//   const files: FileList = event.target.files;
//     if (files.length > 0) {
//       this.selectedFile = files[0];
//     } else {
//       this.selectedFile = null;
//     }
// }

// onFileSelect(event){
//   if (event.target.files.length > 0) {
//     const file = event.target.files[0];
//     if (file.length  !=null) {
//       this.bookForm.get('profile')?.setValue(file)
//           } else {
            
//           }
    
//   }
// }


}
