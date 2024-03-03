
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
    id:Number;
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
        this.id =0;
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

export class Appointment{
    scheduledFor:any[];
    patient:CurrentUser;
    doctor:CurrentUser;
    username:string;

    constructor(){
        this.scheduledFor =[];
        this.patient= new CurrentUser();
        this.doctor = new CurrentUser();
        this.username ="";

    }
}