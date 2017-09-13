import { Injectable } from '@angular/core';
import { Group } from '../models/group';
import { APIService } from '../common/api.service';
import { Observable } from "rxjs/Observable";

@Injectable()
export class GroupService extends APIService{

    getGroupByName(name:string): Observable<Group>{
        return this.get("group/"+name);
    }



}
