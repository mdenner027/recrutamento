import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HeaderService } from 'src/app/components/tamplate/header/header.service';

@Component({
  selector: 'app-responsaveis',
  templateUrl: './responsaveis.component.html',
  styleUrls: ['./responsaveis.component.css']
})
export class ResponsaveisComponent implements OnInit {

  constructor(private router: Router, private headerService:HeaderService) { 
    headerService.headerData.header = "Responsáveis";
  }

  ngOnInit(): void {
  }

  redirectAdiciona() {
    this.router.navigate(["/cadastrar-responsavel"]);
  }
}
