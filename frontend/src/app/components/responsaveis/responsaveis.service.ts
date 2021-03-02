import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { Responsavel } from './responsavel.model';

@Injectable({
  providedIn: 'root'
})
export class ResponsaveisService {

  baseUrl = "http://localhost:8080/admin/responsaveis";

  constructor(private snackBar: MatSnackBar, private http: HttpClient) { }

  showMessage(msg: string): void {
    this.snackBar.open(msg, 'fechar', {
      duration: 3000,
      horizontalPosition: 'right',
      verticalPosition: 'top'
    })
  }

  save(responsavel: Responsavel): Observable<Responsavel> {
    return this.http.post<Responsavel>(this.baseUrl, responsavel);
  }

  update(responsavel: Responsavel): Observable<Responsavel> {
    return this.http.put<Responsavel>(this.baseUrl, responsavel);
  }

  get(): Observable<Responsavel[]> {
    return this.http.get<Responsavel[]>(this.baseUrl);
  }

  delete(idResponsavel: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${idResponsavel}`);
  }

  findById(idResponsavel: string):Observable<Responsavel>{
    return this.http.get<Responsavel>(`${this.baseUrl}/${idResponsavel}`);
  }
}
