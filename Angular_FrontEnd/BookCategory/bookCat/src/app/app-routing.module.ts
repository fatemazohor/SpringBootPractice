import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ImgaeUploadComponent } from './imgae-upload/imgae-upload.component';
import { BookComponent } from './book/book.component';

const routes: Routes = [
  {path:"book",component:BookComponent},
  {path:"image",component:ImgaeUploadComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
