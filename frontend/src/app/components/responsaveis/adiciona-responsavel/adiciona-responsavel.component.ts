import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ResponsaveisService } from '../responsaveis.service';
import { Responsavel } from '../responsavel.model';

@Component({
  selector: 'app-adiciona-responsavel',
  templateUrl: './adiciona-responsavel.component.html',
  styleUrls: ['./adiciona-responsavel.component.css']
})
export class AdicionaResponsavelComponent implements OnInit {

  responsavel: Responsavel = {
    nomeResponsavel: '',
    idResponsavel: null
  }

  constructor(private router: Router, private service: ResponsaveisService) { }

  ngOnInit(): void {
  }

  saveResponsavel(): void {
    this.service.save(this.responsavel).subscribe(() =>{
      this.service.showMessage("Responsável cadastrado com sucesso!");
      this.router.navigate(['/responsaveis']);
    }, () =>{
      this.service.showMessage("Ops! Algo de errado aconteceu");
      this.router.navigate(['/responsaveis']);
    })
  }

  voltar(): void {
    this.router.navigate(['/responsaveis']);
  }
}
