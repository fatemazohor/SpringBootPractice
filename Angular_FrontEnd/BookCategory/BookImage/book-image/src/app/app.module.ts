import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { initializeApp, provideFirebaseApp } from '@angular/fire/app';
import { getAuth, provideAuth } from '@angular/fire/auth';
import { getFirestore, provideFirestore } from '@angular/fire/firestore';
import { LoginComponent } from './component/login/login.component';
import {AngularFireModule} from '@angular/fire/compat'
import { environment } from '../environments/environment';
import { RegisterComponent } from './component/register/register.component';
import { MainLayoutComponent } from './component/main-layout/main-layout.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { LogLayoutComponent } from './component/log-layout/log-layout.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    MainLayoutComponent,
    DashboardComponent,
    LogLayoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    // AngularFireModule.initializeApp(environment.firebase),
    provideFirebaseApp(() => initializeApp({"projectId":"book-image-be91c","appId":"1:46824861084:web:d4b3a22a1ea62c33e46c59","storageBucket":"book-image-be91c.appspot.com","apiKey":"AIzaSyDzPreYdFKVYQNfkcm6c37Vcd7rLCeum7A","authDomain":"book-image-be91c.firebaseapp.com","messagingSenderId":"46824861084"})),
    provideAuth(() => getAuth()),
    provideFirestore(() => getFirestore())
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
