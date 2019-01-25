import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule} from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { MDBBootstrapModule } from 'angular-bootstrap-md';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthComponent } from './component/user/auth/auth.component';
import { RegistComponent } from './component/user/regist/regist.component';
import { ForgotComponent } from './component/user/forgot/forgot.component';
import { UiModule } from './component/ui/ui.module';
import { AuthInterceptor } from './common/interceptor/auth.interceptor';
import { ErrorInterceptor } from './common/interceptor/error.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    AuthComponent,
    RegistComponent,
    ForgotComponent
  ],
  imports: [
    MDBBootstrapModule.forRoot(),
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    UiModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
