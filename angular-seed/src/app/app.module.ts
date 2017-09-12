import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import {FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppConfiguration } from './common/config/app-configuration.service';
import { INITIAL_CONFIG } from './common/config/initial-config';

import { AppComponent } from './app.component';

import { HomePageComponent } from './pages/home-page/home-page.component';
import { TaskListPageComponent } from './pages/task-list-page/task-list-page.component';
import { TaskEditPageComponent } from './pages/task-edit-page/task-edit-page.component';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';
import { UserEditPageComponent } from './pages/user-edit-page/user-edit-page.component';
import { EditInfoPageComponent } from './pages/edit-info/edit-info-page.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { TodoService } from './services/todo.service';
import { GroupService } from './services/group.service'
import { HttpModule } from '@angular/http';
import { SingInPageComponent } from './pages/sign-in/sing-in-page.component';
import { AuthService } from './common/auth.service';
import { AppDataService } from './common/app-data.service';
import { UsersService } from './services/users.service';
import { UserListPageComponent } from "./pages/user-list-page/user-list-page.component";
import { UserProfilePageComponent } from "./pages/user-profile/user-profile-page.component";

const ROUTES = [
  { path: '', component: HomePageComponent },
    { path: 'signin', component: SingInPageComponent },
    { path: 'profile', component: UserProfilePageComponent },
  { path: 'home', component: HomePageComponent },
    { path: 'info', component: EditInfoPageComponent },

    {
    path: 'tasks', component: SingInPageComponent,
    canActivate: [AuthService],
  },
  {
    path: 'users', component: UserListPageComponent,
  },
    {
        path: 'newuser', component: UserEditPageComponent,


    },

  {
    path: 'edit', component: TaskEditPageComponent,
    canActivate: [AuthService],
  },
  {
    path: '**', component: PageNotFoundComponent
  }
]

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    TaskListPageComponent,
    TaskEditPageComponent,
    PageNotFoundComponent,
    SingInPageComponent,
    UserListPageComponent,
      UserEditPageComponent,
      UserProfilePageComponent,
      EditInfoPageComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(ROUTES),
    FormsModule,
    ReactiveFormsModule,
    HttpModule
  ],
  providers: [
    {
      provide: INITIAL_CONFIG,
      useValue: {
        apiURL: 'http://localhost:8080'
      }
    },
    TodoService,
    AuthService,
    AppDataService,
    UsersService,
    AppConfiguration,
    GroupService],
  bootstrap: [AppComponent]
 })
 export class AppModule { }
