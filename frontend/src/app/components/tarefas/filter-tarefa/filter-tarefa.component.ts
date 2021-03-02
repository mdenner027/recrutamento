import { Component, OnInit } from '@angular/core';
import { ResponsaveisService } from '../../responsaveis/responsaveis.service';
import { Responsavel } from '../../responsaveis/responsavel.model';

@Component({
  selector: 'app-filter-tarefa',
  templateUrl: './filter-tarefa.component.html',
  styleUrls: ['./filter-tarefa.component.css']
})
export class FilterTarefaComponent implements OnInit {

  responsaveis: Responsavel[];

  constructor(private service: ResponsaveisService) { }

  ngOnInit(): void {
    this.service.get().subscribe(list => {
      this.responsaveis = list;
    }, () =>{
      this.service.showMessage("Ops! Não foi possível listar os responsáveis");
    })
  }

}
