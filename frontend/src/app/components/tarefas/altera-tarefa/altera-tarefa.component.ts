import { Component, OnInit } from '@angular/core';
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

  tarefa: Tarefa = {
    deadlineTarefa: '',
    prioridadeTarefa: null,
    descricaoTarefa: '',
    responsavelTarefa: null,
    tituloTarefa: '',
    idTarefa: null,
    statusTarefa: null
  }

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
