import { Injectable } from '@angular/core';
import { Group } from '../models/group';
import { User } from '../models/user';
import { APIService } from '../common/api.service';
import { Observable } from "rxjs/Observable";
import { AppConfiguration } from '../common/config/app-configuration.service';
import { AuthService } from '../common/auth.service';
import { Http } from '@angular/http';

@Injectable()
export class GroupService extends APIService{
    private resourceUrl = 'group/groups';

    constructor(
        public config: AppConfiguration,
        public authService: AuthService,
        public http: Http
      ) {
        super(config, authService, http);
      }

    getGroupByName(name:string): Observable<Group>{
        return this.get(this.resourceUrl + "/groupname",name);
    }
    create(name: string, instructor: User, place:string,  days:string[], hour:string,description:string, category:string):Observable<Group>{
        return this.post(this.resourceUrl,new Group(name,instructor,place, days, hour,description, category));
      }



}