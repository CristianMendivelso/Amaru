import { Component, OnInit } from '@angular/core';
import { User } from "../../models/user";
import { UsersService } from "../../services/users.service";
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
    selector: 'app-user-profile-page',
    templateUrl: './user-profile-page.component.html',
    styleUrls: ['./user-profile-page.component.css']
})
export class UserProfilePageComponent implements OnInit {
    private user: User;
    userForm: FormGroup;
    private username:string;

    constructor(public usersService: UsersService,   public router: Router,    public formBuilder: FormBuilder,

    )  {

    }


    isInstructor() {
        if (this.user.type==='INSTRUCTOR'){
            return false;
        }
        else{
            return true;
        }
    }


    onSubmitRate() {

        this.usersService.editRate(
            this.username,
            this.userForm.get('sel1').value
        ).subscribe(serverResponse9=>{
            this.router.navigate(['']);
        }, error=>{
            console.log(error);
        });
        this.router.navigate(['']);

    }

    ngOnInit() {
        this.userForm = this.formBuilder.group({
            newRate: ''
        });
        this.username=sessionStorage.getItem('username');
        this.usersService.findUserByUsername(this.username).subscribe(usersResponse4 => {
            this.user = usersResponse4;
        })
    }



}
