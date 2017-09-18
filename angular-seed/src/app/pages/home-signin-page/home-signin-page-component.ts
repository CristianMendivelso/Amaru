import { Component, OnInit } from '@angular/core';
import {User} from "../../models/user";
import { UsersService } from "../../services/users.service";
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import {Group} from "../../models/group";

@Component({
    selector: 'app-home-signin-page',
    templateUrl: './home-signin-page.component.html',
    styleUrls: ['./home-signin-page.component.css']
})
export class HomeSigninPageComponent implements OnInit {

    private user: User;
    private username:string;
    private groups: Group[] = [];


    constructor(public usersService: UsersService,   public router: Router,    public formBuilder: FormBuilder,) { }

    isInstructor() {
        if (this.user.type==='INSTRUCTOR'){
            return true;
        }
        else{
            return false;
        }
    };
    isAmaru() {
        if (this.user.type==='AMARU'){
            return true;
        }
        else{
            return false;
        }
    }

    ngOnInit() {
        this.username=sessionStorage.getItem('username');
        this.usersService.findUserByUsername(this.username).subscribe(usersResponse4 => {
            this.user = usersResponse4;
            this.groups=this.user.groups;
        })
    }


}
