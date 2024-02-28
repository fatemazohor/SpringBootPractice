import { Component, OnInit } from '@angular/core';
import { FileHandle, ProductImage } from '../model/book.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { BookServiceService } from '../service/book-service.service';


@Component({
  selector: 'app-imgae-upload',
  templateUrl: './imgae-upload.component.html',
  styleUrl: './imgae-upload.component.css'
})
export class ImgaeUploadComponent implements OnInit {

  status: "initial" | "uploading" | "success" | "fail" = "initial";
  
  //product model
  product: ProductImage = new ProductImage()
  productForm!: FormGroup
  showImage: any
  menuType: boolean = false
  constructor(
    private formBuilder: FormBuilder,
    private service:BookServiceService,
    private sanitizer:DomSanitizer
  ) { }
  ngOnInit(): void {
    this.productForm = this.formBuilder.group({
      pname: ['',Validators.required],
      pDescription: ['',Validators.required],
      pImage:['',Validators.required]
    })
  }

  onFileSelect(event: any) {
    console.log("file selected")
    console.log(event);
    if (event.target.files[0]) {
      const file = event.target.files[0];
      // show image preview a
      this.showImage = file;
      
      this.status= "uploading";
      const fileHandle:FileHandle = {
        previewFile:file,
        url:this.sanitizer.bypassSecurityTrustUrl(
          window.URL.createObjectURL(file)
        )
      } 
      //----image preview ------
      this.product.pImage=fileHandle
      //blob image url (optional)
      console.log(this.product.pImage?.url);
      this.menuType = true
      //send data to api
    }
  }
  resetImage(){
    // Clear the selected image
    this.showImage = null;
    
    // Reset status and other related properties
    this.status = "initial"; // Reset the status to empty or to its initial state
    if(this.product.pImage !=undefined){
      this.product.pImage = undefined;
      this.productForm.controls['pImage'].reset();
    }
     // Clear the selected image from the product object
    this.menuType = false; // Reset any related properties or flags
  }
  //prepare form data
  prepareFromData(product:ProductImage):FormData{

    const formData=new FormData();
    // fromgroup data append
    formData.append(
      'product',
      new Blob([JSON.stringify(product)],{type:'application/json'})
    );
    // image append
    // Check if pImage and previewFile are defined before appending the image
    if (product.pImage && product.pImage.previewFile) {
      formData.append(
          'imageFile',
          product.pImage.previewFile,
          product.pImage.previewFile.name
      );
  }
    // formData.append(
    //   'imageFile', 
    //   product.pImage?.previewFile,
    //   product.pImage?.previewFile.name
    // )
    return formData;   
  }
onSubmit(){
  this.product.pname=this.productForm.value.pname
  this.product.pDescription=this.productForm.value.pDescription
  const productFromData = this.prepareFromData(this.product);
  console.log(productFromData);
  this.service.createProduct(productFromData).subscribe({
    next:res=>{
      console.log(res)
      alert("product saved")
      this.productForm.reset();
      this.status= "success";
    },
    error:err=>{
      console.log(err);
      alert('Data not saved.')
      this.status= "fail";
      
    }
  })
}

}
