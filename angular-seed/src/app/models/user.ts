export class User {
    private name: string;
    private lastname: string;
    private image: string;
    private username:string;
    private password:string;
    private email:string;
    
        constructor(name: string, lastname: string, image: string, username:string,password:string,email:string) {
            this.name = name;
            this.lastname = lastname;
            this.image = image;
            this.username=username;
            this.password=password;
            this.email=email;
        }
    }
