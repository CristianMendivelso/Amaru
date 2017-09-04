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

  create(name: string, lastname: string, image: string, username:string,password:string,email:string):Observable<User>{
    return this.post(this.resourceUrl,new User(name,lastname,image,username,password,email));
  }


}