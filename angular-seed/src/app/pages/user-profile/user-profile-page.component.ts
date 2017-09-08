import { Component, OnInit } from '@angular/core';
import { User } from "../../models/user";
import { UsersService } from "../../services/users.service";

@Component({
    selector: 'app-user-profile-page',
    templateUrl: './user-profile-page.component.html',
    styleUrls: ['./user-profile-page.component.css']
})
export class UserProfilePageComponent implements OnInit {
    private user: User;

    constructor(public usersService: UsersService) {

    }


    isInstructor() {
        if (this.user.type==='INSTRUCTOR'){
            return false;
        }
        else{
            return true;
        }
    }

    ngOnInit() {
        this.usersService.findUserByUsername(sessionStorage.getItem('username')).subscribe(usersResponse4 => {
            this.user = usersResponse4;
        })
    }


}
