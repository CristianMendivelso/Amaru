import { Component, OnInit } from '@angular/core';
import { User } from "../../models/user";
import { Group } from "../../models/group";
import { Comment } from "../../models/comment";
import { UsersService } from "../../services/users.service";
import { GroupService } from "../../services/group.service";
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
    selector: 'app-group-profile-page',
    templateUrl: './group-profile-page.component.html',
    styleUrls: ['./group-profile-page.component.css']
})
export class GroupProfilePageComponent implements OnInit {
    private user: User;
	private instructor : User;
    private group: Group;
    comentarios:Comment [];
    groupForm: FormGroup;
    private username:string;
    private groupname:string;

    constructor(public groupService :GroupService,public usersService: UsersService,   public router: Router,    public formBuilder: FormBuilder,)  {


    }


    isSameInstructor() {
        if (this.user.username===this.instructor.username){
            return false;
        }
        else{
            return true;
        }
    }

	onSubmitRegister() {
        this.groupService.registerUserInGroup(this.groupname,this.username
        ).subscribe(groupResponse => {
            this.group = groupResponse;
        }, error=>{
            console.log(error);
        });
        this.router.navigate(['/']);

    }
    onSubmitRate() {
        this.usersService.editRate(
            this.username,
            this.groupForm.get('newRate').value
        ).subscribe(serverResponse9=>{
            this.router.navigate(['/']);
        }, error=>{
            console.log(error);
        });
        this.router.navigate(['/']);

    }

    ngOnInit() {
        this.groupForm = this.formBuilder.group({
            newRate: ''
        });
        this.username=sessionStorage.getItem('username');
		this.groupname = sessionStorage.getItem('groupname');
        this.usersService.findUserByUsername(this.username).subscribe(usersResponse4 => {
            this.user = usersResponse4;
        })
        this.groupService.getGroupByName(this.groupname).subscribe(usersResponse5 => {
            this.group = usersResponse5;
            this.comentarios=this.group.comments;
			this.instructor = this.group.instructor;

        })
    }



}