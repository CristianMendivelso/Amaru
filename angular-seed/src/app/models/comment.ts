export class Comment {
    text: string;
    user: string;
    private date: boolean;

    constructor(text:string, user:string, date:boolean) {
        this.text = text;
        this.user = user;
        this.date = date;
    }
}


