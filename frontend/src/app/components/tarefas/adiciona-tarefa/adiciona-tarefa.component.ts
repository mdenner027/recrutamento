import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ResponsaveisService } from '../../responsaveis/responsaveis.service';
import { Responsavel } from '../../responsaveis/responsavel.model';
import { Tarefa } from '../tarefa.model';
import { TarefasService } from '../tarefas.service';

@Component({
  selector: 'app-adiciona-tarefa',
  templateUrl: './adiciona-tarefa.component.html',
  styleUrls: ['./adiciona-tarefa.component.css']
})
export class AdicionaTarefaComponent implements OnInit {

  tarefa: Tarefa = {
    tituloTarefa: '',
    descricaoTarefa: '',
    prioridadeTarefa: null,
    statusTarefa: null,
    deadlineTarefa: '',
    responsavelTarefa: {
      idResponsavel: null,
      nomeResponsavel: ''
    }
  }

  responsaveis: Responsavel[];

  constructor(private router: Router, private service:TarefasService,private responService: ResponsaveisService) { }

  ngOnInit(): void {
    this.responService.get().subscribe(list => {
      this.responsaveis = list;
    }, () => {
      this.responService.showMessage("Ops! Não foi possível listar os responsáveis.");
    })
  }

  saveTarefa():void {
    let date = new Date(this.tarefa.deadlineTarefa);
    this.tarefa.deadlineTarefa = date.toLocaleDateString();
    alert(this.tarefa.deadlineTarefa);
    this.service.saveTarefa(this.tarefa).subscribe(() => {
      this.service.showMessage("Tarefa cadastrada com sucesso!");
      this.router.navigate(['/tarefas']);
    }, () =>{
      this.service.showMessage("Ops! Algo de errado aconteceu ao cadastrar a tarefa.");
    });
  }

  voltar() {
    this.router.navigate(["/tarefas"]);
  }
}
