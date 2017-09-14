export class User {

    private name: string;
    private lastname: string;
    private image: string;
    private phone:string;
    private password:string;
    private email:string;
    private description:string;
    private rate:number;
    private totalVotes:number;
    type:string;
    username:string;
    
        constructor(name: string, lastname: string, image: string, phone:string,password:string,email:string,description:string,type:string,username:string,rate:number,totalVotes:number) {
            this.name = name;
            this.lastname = lastname;
            this.image = image;
            this.phone=phone;
            this.password=password;
            this.email=email;
            this.description=description;
            this.type=type;
            this.username=username;
            this.rate=rate;
            this.totalVotes=totalVotes;
        }
    }
