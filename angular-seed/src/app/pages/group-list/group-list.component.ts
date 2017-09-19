import { Component, OnInit } from '@angular/core';
import { GroupService } from '../../services/group.service';
import { Group } from '../../models/group'

@Component({
  selector: 'app-group-list',
  templateUrl: './group-list.component.html',
  styleUrls: ['./group-list.component.css']
})
export class GroupListComponent implements OnInit {
  groups:Group[]=[];
  name:String;
  constructor( public groupService:GroupService ) { }

  ngOnInit() {
    this.groupService.getGroupByCategory(name).subscribe(categories =>{
      this.groups=categories;
    })
  }

  setGroup(name){
    this.name=null;
    this.name=name;
  }

}
