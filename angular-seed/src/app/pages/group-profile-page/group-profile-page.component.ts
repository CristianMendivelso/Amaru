import { Component, OnInit } from '@angular/core';
import { User } from "../../models/user";
import { Group } from "../../models/group";
import { Comment } from "../../models/comment";
import { UsersService } from "../../services/users.service";
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { GroupService } from '../../services/group.service';

@Component({
    selector: 'app-group-profile-page',
    templateUrl: './group-profile-page.component.html',
    styleUrls: ['./group-profile-page.component.css']
})
export class GroupProfilePageComponent implements OnInit {
    private user: User;
    private group: Group;
    comentarios:Comment [];
    userForm: FormGroup;
    private username:string;
    private groupname:string;

    constructor(public usersService: UsersService,   public router: Router,    public formBuilder: FormBuilder, public groupService:GroupService)  {

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
            this.userForm.get('newRate').value
        ).subscribe(serverResponse9=>{
            this.router.navigate(['/']);
        }, error=>{
            console.log(error);
        });
        this.router.navigate(['/']);

    }

    ngOnInit() {
        this.userForm = this.formBuilder.group({
            newRate: ''
        });
        this.username=sessionStorage.getItem('username');
        this.groupname=sessionStorage.getItem('groupname');
        this.usersService.findUserByUsername(this.username).subscribe(usersResponse4 => {
            this.user = usersResponse4;
        })
        this.groupService.getGroupByName(this.groupname).subscribe(usersResponse5 => {
            this.group = usersResponse5;
            this.comentarios=this.group.comments;

        })
    }



}
