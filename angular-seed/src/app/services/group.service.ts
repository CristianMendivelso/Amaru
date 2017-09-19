import { Injectable } from '@angular/core';
import { Group } from '../models/group';
import { User } from '../models/user';
import { Comment } from '../models/comment';
import { APIService } from '../common/api.service';
import { Observable } from "rxjs/Observable";
import { AppConfiguration } from '../common/config/app-configuration.service';
import { AuthService } from '../common/auth.service';
import { Http } from '@angular/http';

@Injectable()
export class GroupService extends APIService{
    private resourceUrl = 'group/';
    group:Group;
    constructor(
        public config: AppConfiguration,
        public authService: AuthService,
        public http: Http
      ) {
        super(config, authService, http);
      }

    getGroupByName(name:string): Observable<Group>{
        return this.get(this.resourceUrl+ name);
    }
    create(name: string, instructor: User, place:string,  days:string[], hour:string,description:string, category:string, comments: Comment[], rate:number, totalVotes:number, image:string):Observable<Group>{
        return this.post(this.resourceUrl + "groups",new Group(name,instructor,place, days, hour,description, category, comments, rate, totalVotes, image));
      }
    registerUserInGroup(groupname: string, user: String): Observable<Group>{
        return this.get(this.resourceUrl+ "register/" + groupname + "," +user)
    }
    editRate(groupname: string, rate: number){
        return this.post(this.resourceUrl + 'rate',{groupname,rate});
    }

    getGroupByCategory(name:string):Observable<Group[]>{
        return this.get(this.resourceUrl+"groups/"+name);
    }

    addComment(co:Comment) {
        return this.post(this.resourceUrl + 'comment', co);
    }



}