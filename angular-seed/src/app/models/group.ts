export class Group {
    private text: string;
    private user: string;
    private date: boolean;

    constructor(text:string, user:string, date:boolean) {
        this.text = text;
        this.user = user;
        this.date = date;
    }
}