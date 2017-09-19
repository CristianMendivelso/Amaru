import { User } from "./user";
import { Comment } from "./comment";
import { Observable } from "rxjs/Observable";

export class Group {
    name: string;
    public instructor: User;
    private students: Array<User>;
    private score:number;
    comments: Comment[];
    private place:string;
    private hour:string;
    private days:string[];
    private description:string;
    private category:string;
	private rate:number;
    private totalVotes:number;
    private image:string;
	
        constructor(name: string, instructor: User, place:string,  days:string[], hour:string, description:string, category:string, comment: Comment[], rate:number, totalVotes:number, image:string ) {
            this.name = name;
            this.instructor = instructor;
            this.students = new Array<User>();
            this.score = 50;
            this.comments=comment;
            this.place = place;
            this.hour = hour;
            this.days = days;
            this.description = description;
            this.category = category;
			this.rate=rate;
            this.totalVotes=totalVotes;
            this.image = image;
        }
    }
