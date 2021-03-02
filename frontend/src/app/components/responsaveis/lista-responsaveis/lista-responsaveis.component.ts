import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ResponsaveisService } from '../responsaveis.service';
import { Responsavel } from '../responsavel.model';

@Component({
  selector: 'app-lista-responsaveis',
  templateUrl: './lista-responsaveis.component.html',
  styleUrls: ['./lista-responsaveis.component.css']
})
export class ListaResponsaveisComponent implements OnInit {

  displayedColumns = ['numero', 'nome', 'actions'];

  responsaveis: Responsavel[];

  constructor(private service: ResponsaveisService) { }

  ngOnInit(): void {
    this.refresh();
  }

  refresh(){
    this.service.get().subscribe(lista => {
      this.responsaveis = lista;
    }, () => {
      this.service.showMessage("Ops! Não foi possível exibir os registros.");
    });
  }

  removeResponsavel(idResponsavel: number): void {
    this.service.delete(idResponsavel).subscribe(() => {
      this.service.showMessage("Responsável removido com sucesso!");
      this.refresh();
    }, () => {
      this.service.showMessage("Ops! Não foi possível remover o registro.");
    });
  }

}
