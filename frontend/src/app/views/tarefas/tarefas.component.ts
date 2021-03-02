import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HeaderService } from 'src/app/components/tamplate/header/header.service';

@Component({
  selector: 'app-tarefas',
  templateUrl: './tarefas.component.html',
  styleUrls: ['./tarefas.component.css']
})
export class TarefasComponent implements OnInit {

  constructor(private router: Router, headerService: HeaderService) {
    headerService.headerData.header = "Tarefas";
  }

  ngOnInit(): void {
  }

  adicionarTarefaRedirect() {
    this.router.navigate(["/cadastrar-tarefa"]);
  }

}
