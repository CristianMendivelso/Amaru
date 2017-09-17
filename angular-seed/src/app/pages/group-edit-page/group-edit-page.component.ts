import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { GroupService } from "../../services/group.service";
import { UsersService } from "../../services/users.service";
import { Observable } from 'rxjs/Observable';
import { User } from '../../models/user';

@Component({
  selector: 'app-group-edit-page',
  templateUrl: './group-edit-page.component.html',
  styleUrls: ['./group-edit-page.component.css'],
  
})
export class GroupEditPageComponent implements OnInit {
  days:string[] = [];
  groupForm: FormGroup; 
  user :User;
  constructor(
    public groupService: GroupService,
    public usersService: UsersService,
    public formBuilder: FormBuilder,
    public router: Router,
  ) {
    
  }

  ngOnInit() {
    this.groupForm = this.formBuilder.group({
      name: '',
      place: '',
      day1: '',
      day2: '',
      day3: '',
      day4: '',
      day5: '',
      day6: '',
      day7:'',
      hour:'',
      description:'',
      category: ''
    });
    this.usersService.findUserByUsername(sessionStorage.getItem('username')).subscribe(usersResponse4 => {
      this.user = usersResponse4;
    })

  }

  onSubmit() {
    
    if (this.groupForm.get('day1').value){
      this.days.push("Monday") 
    }
    if (this.groupForm.get('day2').value){
      this.days.push("Tuesday") 
    }
    if (this.groupForm.get('day3').value){
      this.days.push("Wednesday") 
    }
    if (this.groupForm.get('day4').value){
      this.days.push("Thursday") 
    }
    if (this.groupForm.get('day5').value){
      this.days.push("Friday") 
    }
    if (this.groupForm.get('day6').value){
      this.days.push("Saturday") 
    }
    if (this.groupForm.get('day7' ).value){
      this.days.push("Sunday") 
    }
    this.days 
    sessionStorage.setItem('groupname', this.groupForm.get('name').value);
    this.groupService.create(
      this.groupForm.get('name').value,
      this.user,
      this.groupForm.get('place').value,
      this.days,
      this.groupForm.get('hour').value,
      this.groupForm.get('description').value,
      this.groupForm.get('category').value
    ).subscribe(serverResponse=>{
        this.router.navigate(['/group']);
    }, error=>{
      console.log(error);
    });
  
 
  }

}