export class User{
    email: String;
    password:String;

    constructor(){
        this.email='';
        this.password ='';
    }
}
export class Register{
    email: String;
    password:String;
    name:String;
    title:String;
    info:String;

    constructor(){
        this.email="";
        this.password="";
        this.name ="";
        this.title="";
        this.info ="";
    }
}
export class ErrorRegister{
    email: String;
    password:String;
    name:String;
    title:String;
    info:String;

    constructor(){
        this.email="";
        this.password="";
        this.name ="";
        this.title="";
        this.info ="";
    }
}
export class CurrentUser{
    email: String;
    password:String;
    name:String;
    title:String;
    info:String;
    role:String;
    username:String;
    authorities:any[];
    patiensDepartments:any[];
    staffDepartments: any[];

    constructor(){
        this.email="";
        this.password="";
        this.name ="";
        this.title="";
        this.info ="";
        this.role ="";
        this.username="";
        this.authorities=[];
        this.patiensDepartments=[];
        this.staffDepartments=[];
    }
}