import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ResponsaveisService } from '../responsaveis.service';
import { Responsavel } from '../responsavel.model';

@Component({
  selector: 'app-altera-responsavel',
  templateUrl: './altera-responsavel.component.html',
  styleUrls: ['./altera-responsavel.component.css']
})
export class AlteraResponsavelComponent implements OnInit {

  responsavel: Responsavel = {
    idResponsavel: null,
    nomeResponsavel: ''
  };

  constructor(
    private responsavelService: ResponsaveisService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.responsavelService.findById(id).subscribe(responsavel => {
      this.responsavel = responsavel;
    }, () => {
      this.responsavelService.showMessage("Ops! Algo de errado aconteceu.");
    });
  }

  updateResponsavel(): void {
    this.responsavelService.update(this.responsavel).subscribe(() => {
      this.router.navigate(['/responsaveis']);
      this.responsavelService.showMessage("Responsável atualizado com sucesso!")
    }, () => {
      this.router.navigate(['/responsaveis']);
      this.responsavelService.showMessage("Ops! Algo de errado aconteceu.");
    });
  }

  voltar(): void {
    this.router.navigate(['/responsaveis']);
  }

}
