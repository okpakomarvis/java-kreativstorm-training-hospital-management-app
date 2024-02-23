import {Component, Input} from '@angular/core';
import {User} from "../user";

@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.css']
})
export class PatientDetailsComponent {
  @Input() public patient: User | undefined;
}
