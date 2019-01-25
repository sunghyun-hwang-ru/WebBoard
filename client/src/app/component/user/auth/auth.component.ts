import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { UserService } from '../../../common/services/user.service';
import { AlertService } from '../../../common/services/alert.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']
})
export class AuthComponent implements OnInit {

  loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  loginStatus = false;
  alertMessage: string;

  constructor(
      private formBuilder: FormBuilder,
      private route: ActivatedRoute,
      private router: Router,
      private userService: UserService,
      private alertService: AlertService
  ) {
      // redirect to home if already logged in
      if (this.userService.currentUserValue) {
          this.router.navigate(['/']);
      }
  }

  ngOnInit() {
      this.loginForm = this.formBuilder.group({
          userCd: ['', Validators.required],
          userPass: ['', Validators.required]
      });

      // get return url from route parameters or default to '/'
      this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  // convenience getter for easy access to form fields
  get f() { return this.loginForm.controls; }

  login(e: Event) {
      this.submitted = true;

      // stop here if form is invalid
      if (this.loginForm.invalid) {
          return;
      }

      this.loading = true;
      this.userService.login(this.f.userCd.value, this.f.userPass.value)
          .pipe(first())
          .subscribe(
              data => {
                  if (data.token === '1') {
                    this.loginStatus = true;
                    this.alertMessage = '';
                    this.router.navigate([this.returnUrl]);
                  } else {
                    this.alertMessage = data.loginMsg;
                    this.loading = false;
                  }
              },
              error => {
                  this.alertService.error(error);
                  this.loading = false;
              });
  }

  closeMessage() {
      this.alertMessage = '';
  }
}
