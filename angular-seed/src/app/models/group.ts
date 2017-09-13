import { User } from "./user";
import { Comment } from "./comment";

export class Group {
    private name: string;
    private instructor: User;
    private students: Array<User>;
    private score:number;
    private comments: Array<Comment>;
    private place:string;
    private hour:string;
    private days:string[];
    private description:string;
        constructor(name: string, instructor: User, place:string,  days:string[], hour:string, description:string) {
            this.name = name;
            this.instructor = instructor;
            this.students = new Array<User>();
            this.score = 0;
            this.comments = new Array<Comment>();
            this.place = place;
            this.hour = hour;
            this.days = days;
            this.description = description;
        }
    }
