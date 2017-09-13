import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { GroupService } from "../../services/group.service";

@Component({
  selector: 'app-group-edit-page',
  templateUrl: './group-edit-page.component.html',
  styleUrls: ['./group-edit-page.component.css'],
  
})
export class GroupEditPageComponent implements OnInit {
  days:string[] = [];
  constructor(
    public groupService: GroupService,
    public router: Router,
  ) {
    
  }

  ngOnInit() {
      

  }

  onSubmit(name,place,monday,tuesday,wednesday,thursday,friday, saturday, sunday,hour,description) {
    if (monday){
      this.days.push("Monday") 
    }
    if (tuesday){
      this.days.push("Tuesday") 
    }
    if (wednesday){
      this.days.push("Wednesday") 
    }
    if (thursday){
      this.days.push("Thursday") 
    }
    if (friday){
      this.days.push("Friday") 
    }
    if (saturday){
      this.days.push("Saturday") 
    }
    if (sunday){
      this.days.push("Sunday") 
    }
    this.days 
    this.groupService.create(
      name,
      null,
      place,
      this.days,
      hour,
      description
    ).subscribe(serverResponse=>{
        this.router.navigate(['/groups']);
    }, error=>{
      console.log(error);
    });
  
 
    this.router.navigate(['/groups']);
  }

}