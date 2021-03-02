import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ResponsaveisService } from '../../responsaveis/responsaveis.service';
import { Responsavel } from '../../responsaveis/responsavel.model';
import { Tarefa } from '../tarefa.model';
import { TarefasService } from '../tarefas.service';

@Component({
  selector: 'app-altera-tarefa',
  templateUrl: './altera-tarefa.component.html',
  styleUrls: ['./altera-tarefa.component.css']
})
export class AlteraTarefaComponent implements OnInit {

  public options = [
    { "value": 0, "name": "Baixa" },
    { "value": 1, "name": "Média" },
    { "value": 2, "name": "Alta" }
  ]

  tarefa: Tarefa = {
    deadlineTarefa: '',
    prioridadeTarefa: null,
    descricaoTarefa: '',
    responsavelTarefa: {
      nomeResponsavel: '',
      idResponsavel: null
    },
    tituloTarefa: '',
    idTarefa: null,
    statusTarefa: null
  }

  date1 = new FormControl(new Date());

  responsaveis: Responsavel[];

  constructor(
    private tarefaService: TarefasService,
    private router: Router,
    private route: ActivatedRoute,
    private responService: ResponsaveisService) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.tarefaService.findById(id).subscribe(tarefa => {
      this.tarefa = tarefa;
      this.date1 = new FormControl(new Date(this.tarefa.deadlineTarefa));
    }, () => {
      this.tarefaService.showMessage("Ops! Algo de errado aconteceu.");
    });
    this.responService.get().subscribe(list => {
      this.responsaveis = list;
    }, () => {
      this.responService.showMessage("Ops! Não foi possível listar os responsáveis.");
    });
  }

  updateTarefa(): void {
    let date = new Date(this.tarefa.deadlineTarefa);
    this.tarefa.deadlineTarefa = date.toLocaleDateString();
    this.tarefaService.update(this.tarefa).subscribe(() => {
      this.router.navigate(['/tarefas']);
      this.tarefaService.showMessage("Tarefa atualizada com sucesso!")
    }, () => {
      this.router.navigate(['/tarefas']);
      this.tarefaService.showMessage("Ops! Algo de errado aconteceu.");
    });
  }

  voltar(): void {
    this.router.navigate(['/tarefas']);
  }

}
