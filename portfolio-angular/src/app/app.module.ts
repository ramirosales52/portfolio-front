import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { NgCircleProgressModule } from 'ng-circle-progress';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { AboutComponent } from './components/about/about.component';
import { XpComponent } from './components/xp/xp.component';
import { EduComponent } from './components/edu/edu.component';
import { HysComponent } from './components/hys/hys.component';
import { ProyectComponent } from './components/proyect/proyect.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    AboutComponent,
    XpComponent,
    EduComponent,
    HysComponent,
    ProyectComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgCircleProgressModule.forRoot({
      
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
