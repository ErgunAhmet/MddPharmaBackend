import { Component, OnInit } from '@angular/core';
import {Service} from '../../service/service';
import {Medication} from '../model/Medication';
import {Router} from '@angular/router';

@Component({
  selector: 'app-addmedication',
  templateUrl: './addmedication.component.html',
  styleUrls: ['./addmedication.component.css']
})
export class AddmedicationComponent implements OnInit {
  name: string;
  type: string;
  status: string;
  medication: Medication;
  constructor(private medicationService: Service, private router: Router) { }

  ngOnInit(): void {
  }
  onFormSubmit() {
      this.medication = new Medication(this.name, this.type, this.status);
    this.medicationService.addMedication(
      this.medication
    ).subscribe()
    this.router.navigate(['/list'])
  }

}
