import { User } from "./user";
import { Comment } from './comment';
export class Group {
    private id: number;
    private name: string;
    private instructor: User;
    private stundents: User[];
    private score: number;
    private comments: Comment[];
    private place: string;
    private hour: string;
    private days: string[];
    private description: string;

    constructor(id:number,name:string,instructor:User,students:User[],score:number,comments:Comment[],place:string,hour:string,days:string[],description:string) {
        this.id=id;
        this.name=name;
        this.instructor=instructor;
        this.stundents=students;
        this.score=score;
        this.comments=comments;
        this.place=place;
        this.hour=hour;
        this.days=days;
        this.description=description;
    }
}
