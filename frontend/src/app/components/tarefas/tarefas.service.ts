import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { TarefaFilter } from './tarefa.filter.model';
import { Tarefa } from './tarefa.model';

@Injectable({
  providedIn: 'root'
})
export class TarefasService {

  baseUrl = "http://localhost:8080/admin/tarefas";

  constructor(private http: HttpClient, private snackBar: MatSnackBar) { }

  showMessage(msg: string): void {
    this.snackBar.open(msg, 'fechar', {
      duration: 3000,
      horizontalPosition: 'right',
      verticalPosition: 'top'
    })
  }

  saveTarefa(tarefa: Tarefa): Observable<Tarefa> {
    return this.http.post<Tarefa>(this.baseUrl, tarefa);
  }

  getTarefas(): Observable<Tarefa[]> {
    return this.http.get<Tarefa[]>(this.baseUrl);
  }

  update(tarefa: Tarefa): Observable<Tarefa> {
    return this.http.put<Tarefa>(this.baseUrl, tarefa);
  }

  findById(idTarefa: string): Observable<Tarefa> {
    return this.http.get<Tarefa>(`${this.baseUrl}/${idTarefa}`);
  }

  delete(idTarefa: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${idTarefa}`);
  }

  concluir(idTarefa: string): Observable<Tarefa> {
    return this.http.patch<Tarefa>(`${this.baseUrl}/${idTarefa}`, null);
  }

  getTarefasFilter(filtro: TarefaFilter): Observable<Tarefa[]> {
    return this.http.get<Tarefa[]>(`${this.baseUrl}/filter`, {
      params: {
        'idTarefa': filtro.idTarefa,
        'tituloOuDescricao': filtro.tituloOuDescricao,
        'statusTarefa': filtro.statusTarefa,
        'idResponsavel': filtro.idResponsavel
      }
    });
  }
}
