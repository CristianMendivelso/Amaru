import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { UsersService } from "../../services/users.service";


@Component({
  selector: 'app-user-edit-page',
  templateUrl: './user-edit-page.component.html',
  styleUrls: ['./user-edit-page.component.css'],
  
})
export class UserEditPageComponent implements OnInit {
   userForm: FormGroup; 
  constructor(
    public userService: UsersService,
    public formBuilder: FormBuilder,
    public router: Router,
  ) {
    
  }

  ngOnInit() {
      this.userForm = this.formBuilder.group({
          email: '',
          password: '',
          nombre: '',
          lastname: '',
          username: '',
          image: ''
    });

  }

  onSubmit() {
    this.userService.create(
      this.userForm.get('nombre').value,
      this.userForm.get('lastname').value,
    this.userForm.get('image').value,
        this.userForm.get('username').value,
        this.userForm.get('password').value,
        this.userForm.get('email').value
    ).subscribe(serverResponse2=>{
        this.router.navigate(['/users']);
    }, error=>{
      console.log(error);
    });
  
 
    this.router.navigate(['/users']);
  }

}
