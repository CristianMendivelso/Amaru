export class Comment {
    text: string;
    user: string;
    groupName: String;

    constructor(text:string, user:string, groupName:string) {
        this.text = text;
        this.user = user;
        this.groupName=groupName;
    }
}


