import { Component, OnInit } from '@angular/core';
import { Group } from '../../models/group';
import { GroupService } from "../../services/group.service";
@Component({
  selector: 'app-group-list',
  templateUrl: './group-list.component.html',
  styleUrls: ['./group-list.component.css']
})
export class GroupListComponent implements OnInit {
  group:Group;
  constructor(public groupService: GroupService) { }

  ngOnInit() {
  }

}
