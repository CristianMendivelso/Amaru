import { Component } from '@angular/core';
import { AuthService } from './common/auth.service';
import { Router } from '@angular/router';
import { Group } from './models/group';
import { GroupService } from "./services/group.service";
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  searchForm: FormGroup;
  group:Group;
  constructor(
    public authService: AuthService,
    public groupService: GroupService,
    public router: Router
  ) {
    if (!this.authService.isLoggedIn()) {
      this.router.navigate(['/']);
    }
  }

  onsubmit(){
    this.group=null;
    this.groupService.getGroupByName(this.searchForm.get("search").value).subscribe(response => {
      this.group=response;
    });
  }

  isLoggedIn() {
    return this.authService.isLoggedIn();
  }

  signOut() {
    this.authService.signOut();
  }


}
