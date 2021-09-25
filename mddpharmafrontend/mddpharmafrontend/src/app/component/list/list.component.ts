import { Component, OnInit } from '@angular/core';
import {Medication} from '../model/Medication';
import {Observable} from 'rxjs';
import {Service} from '../../service/service';
import {Router} from '@angular/router';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  medicationList: Observable<Medication[]>;
  name: string;
  type: string;
  status: string;
  constructor(private medicationService: Service,
              private router: Router) { }

  ngOnInit() {
    this.getAll();
  }
  getAll() {
  this.medicationList = this.medicationService.getMedication();
  }

  onFormSubmit() {
    this.medicationList = this.medicationService.getMedication(
      this.name, this.type, this.status
    );
    this.name = null;
    this.type = null;
    this.status = null;
  }

  changeStatus(id: number, status: string) {
    this.medicationService.changeMedicationStatus(id, status).subscribe();
  }

  delete(id: number, name: string) {
    if(window.confirm(`wil je ${name} verwijderen?`)) {
      this.medicationService.deleteMedication(id).subscribe();
    }
  }
}
