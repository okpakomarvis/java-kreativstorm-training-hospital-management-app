import {Component, OnInit} from '@angular/core';
import {Department} from "../department";
import {DepartmentService} from "../department.service";

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css']
})
export class DepartmentComponent implements OnInit{
  public departments: Department[] | undefined;
  public selectedDepartment: Department | undefined;

  constructor(private departmentService: DepartmentService) {
  }

  ngOnInit(){
    this.getDepartments();
  }

  getDepartments(){
    this.departmentService.getDepartments().subscribe(departments => this.departments = departments);
  }

  onSelect(department: Department){
    this.selectedDepartment = department;
  }

}
