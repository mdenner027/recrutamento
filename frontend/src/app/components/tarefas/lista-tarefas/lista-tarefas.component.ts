import { Component, OnInit } from '@angular/core';
import { ResponsaveisService } from '../../responsaveis/responsaveis.service';
import { Responsavel } from '../../responsaveis/responsavel.model';
import { TarefaFilter } from '../tarefa.filter.model';
import { Tarefa } from '../tarefa.model';
import { TarefasService } from '../tarefas.service';

@Component({
  selector: 'app-lista-tarefas',
  templateUrl: './lista-tarefas.component.html',
  styleUrls: ['./lista-tarefas.component.css']
})
export class ListaTarefasComponent implements OnInit {

  displayedColumns = ['numero', 'titulo', 'responsavel', 'prioridade', 'actions'];

  responsaveis: Responsavel[];

  tarefas: Tarefa[];

  filtro: TarefaFilter = {
    idTarefa: '',
    tituloOuDescricao: '',
    idResponsavel: '',
    statusTarefa: ''
  }

  constructor(private service: TarefasService, private responService: ResponsaveisService) { }

  ngOnInit(): void {
    this.service.getTarefas().subscribe(list => {
      this.tarefas = list;
    }, () => {
      this.service.showMessage("Ops! Não foi possível exibir os registros.");
    });

    this.responService.get().subscribe(list => {
      this.responsaveis = list;
    }, () => {
      this.service.showMessage("Ops! Não foi possível listar os responsáveis");
    });
  }

  filtrarTarefas(): void {
    this.service.getTarefasFilter(this.filtro).subscribe(lista => {
      this.tarefas = lista;
    }, () => {
      this.service.showMessage("Ops! Algo de errado aconteceu");
    });
  }

  limpaFiltro(): void {
    this.filtro = {
      idResponsavel: '',
      idTarefa: '',
      statusTarefa: '',
      tituloOuDescricao: ''
    }
  }
}
