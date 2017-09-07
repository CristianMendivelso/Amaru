import { Component, OnInit } from '@angular/core';
import { User } from "../../models/user";
import { UsersService } from "../../services/users.service";
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
    selector: 'app-edit-info-page',
    templateUrl: './edit-info-page.component.html',
    styleUrls: ['./edit-info-page.component.css']
})
export class EditInfoPageComponent implements OnInit {
    private user: User;
    userForm: FormGroup;


    constructor(public usersService: UsersService,   public router: Router,    public formBuilder: FormBuilder,

    ) {

    }



    onSubmitImage() {

        this.usersService.editImage(
            this.user.username,
            this.userForm.get('newImage').value
        ).subscribe(serverResponse9=>{
            this.router.navigate(['/']);
        }, error=>{
            console.log(error);
        });
        this.router.navigate(['/']);

    }

    onSubmitDescription() {
        this.usersService.editDescription(
            this.user.username,
            this.userForm.get('newDescription').value
        ).subscribe(serverResponse9=>{
            this.router.navigate(['/']);
        }, error=>{
            console.log(error);
        });
        this.router.navigate(['/']);

    }

    onSubmitPhone() {

        this.usersService.editPhone(
            this.user.username,
            this.userForm.get('newPhone').value
        ).subscribe(serverResponse9=>{
            this.router.navigate(['/']);
        }, error=>{
            console.log(error);
        });
        this.router.navigate(['/']);

    }

    onSubmitEmail() {

        this.usersService.editEmail(
            this.user.username,
            this.userForm.get('newEmail').value
        ).subscribe(serverResponse9=>{
            this.router.navigate(['/']);
        }, error=>{
            console.log(error);
        });
        this.router.navigate(['/']);

    }

    ngOnInit() {
        this.userForm = this.formBuilder.group({
            newDescription: '',
            newPhone: '',
            newEmail: '',
            newImage:''
        });
        this.usersService.findUserByUsername("pepito").subscribe(usersResponse4 => {
            this.user = usersResponse4;
        })
    }
}
