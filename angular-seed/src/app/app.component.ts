import { Component } from '@angular/core';
import { AuthService } from './common/auth.service';
import { Router } from '@angular/router';
import { Group } from './models/group';
import { GroupService } from "./services/group.service";
import { FormGroup, FormBuilder, FormControl } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  group:Group;
  constructor(
    public authService: AuthService,
    public router: Router,
    public groupService:GroupService
  ) {
    if (!this.authService.isLoggedIn()) {
      this.router.navigate(['/']);
    }
  }

  isLoggedIn() {
    return this.authService.isLoggedIn();
  }

  signOut() {
    this.authService.signOut();
  }

  entergr() {
    sessionStorage.setItem('groupname',this.group.name);
    this.router.navigate(['/group']);
  }

  onSubmit(search){
    this.group=null;
    this.groupService.getGroupByName(search).subscribe(response => {
      this.group=response;
    });
  }


}
