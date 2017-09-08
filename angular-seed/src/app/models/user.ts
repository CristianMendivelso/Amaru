export class User {
    private name: string;
    private lastname: string;
    private image: string;
    private phone:string;
    private password:string;
    private email:string;
    private description:string;
    type:string;
    username:string;
    
        constructor(name: string, lastname: string, image: string, phone:string,password:string,email:string,description:string,type:string,username:string) {
            this.name = name;
            this.lastname = lastname;
            this.image = image;
            this.phone=phone;
            this.password=password;
            this.email=email;
            this.description=description;
            this.type=type;
            this.username=username;
        }
    }
