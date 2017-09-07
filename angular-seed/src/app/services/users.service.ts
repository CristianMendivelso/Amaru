import { Injectable } from '@angular/core';
import { APIService } from '../common/api.service';
import { AppConfiguration } from '../common/config/app-configuration.service';
import { AuthService } from '../common/auth.service';
import { Http } from '@angular/http';
import { Observable } from "rxjs/Observable";
import { User } from "../models/user";

@Injectable()
export class UsersService extends APIService {

  private resourceUrl = 'user/users';
  
  constructor(
    public config: AppConfiguration,
    public authService: AuthService,
    public http: Http
  ) {
    super(config, authService, http);
  }


    editImage(username: string, image: string){
      return this.post('user/editImage',{username,image});
    }

    editPhone(username: string, phone: string){
        return this.post('user/editPhone',{username,phone});
    }

    editDescription(username: string, description: string){
        return this.post('user/editDescription',{username,description});
    }
    editEmail(username: string, email: string){
        return this.post('user/editEmail',{username,email});
    }



    login(username: string, password: string) {
    return this.post('user/login', { username, password }, { credentials: false }).map(loginResponse => {
      if (loginResponse) {
        this.authService.accessToken = loginResponse.accessToken;
      }
    });
  }


  list(): Observable<User[]> {
    return this.get(this.resourceUrl);
  }
  findUserByUsername(username:string):Observable<User>{
      return this.get("user/"+ username);
  };

  create(name: string, lastname: string, image: string, phone:string,password:string,email:string,description:string,type:string,username:string):Observable<User>{
    return this.post(this.resourceUrl,new User(name,lastname,image,phone,password,email,description,type,username));
  }


}