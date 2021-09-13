import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Medication} from '../component/model/Medication';

@Injectable({
  providedIn: 'root'
})
export class Service {
  private baseUrl = 'http://localhost:8080/mdd';
  constructor(private http: HttpClient) { }

  getMedication(name?: string, type?: string, status?: string): Observable<Medication[]> {
    if (name == null && type == null && status == null) {
      return this.http.get<Medication[]>(`${this.baseUrl}/getAll`);
    }
    if (name != null && type == null && status == null) {
      return this.http.get<Medication[]>(`${this.baseUrl}/findByName/${name}`);
    }
    if (name != null && type != null && status == null) {
      return this.http.get<Medication[]>(`${this.baseUrl}/findByNameAndType/${name}/${type}`);
    }
    if (name != null && type == null && status != null) {
      return this.http.get<Medication[]>(`${this.baseUrl}/findByNameAndStatus/${name}/${status}`);
    }
    if (name != null && type != null && status != null) {
      return this.http.get<Medication[]>(`${this.baseUrl}/findByNameAndType/${name}/${type}/${status}`);
    }
    if (name == null && type != null && status == null) {
      return this.http.get<Medication[]>(`${this.baseUrl}/findByType/${type}`);
    }
    if (name == null && type == null && status != null) {
      return this.http.get<Medication[]>(`${this.baseUrl}/findByStatus/${status}`);
    }
    if (name == null && type != null && status != null) {
      return this.http.get<Medication[]>(`${this.baseUrl}/findByTypeAndStatus/${type}/${status}`);
    }
  }
  changeMedicationStatus(id: number, status: string) {
    return this.http.post<Medication>(`${this.baseUrl}/updateStatus/${id}/${status}`, null);
  }
}
