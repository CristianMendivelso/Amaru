import { Component, OnInit } from '@angular/core';
import { User } from "../../models/user";
import { UsersService } from "../../services/users.service";

@Component({
  selector: 'app-user-list-page',
  templateUrl: './user-list-page.component.html',
  styleUrls: ['./user-list-page.component.css']
})
export class UserListPageComponent implements OnInit {
    private usuarios: User[] = [];

    constructor(public usersService: UsersService) {

    }


    ngOnInit() {
        this.usersService.list().subscribe(usersResponse3 => {
            this.usuarios = usersResponse3;
        })
    }
}
