import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdicionaResponsavelComponent } from './components/responsaveis/adiciona-responsavel/adiciona-responsavel.component';
import { AlteraResponsavelComponent } from './components/responsaveis/altera-responsavel/altera-responsavel.component';
import { AdicionaTarefaComponent } from './components/tarefas/adiciona-tarefa/adiciona-tarefa.component';
import { AlteraTarefaComponent } from './components/tarefas/altera-tarefa/altera-tarefa.component';
import { HomeComponent } from './views/home/home.component';
import { ResponsaveisComponent } from './views/responsaveis/responsaveis.component';
import { TarefasComponent } from './views/tarefas/tarefas.component';

const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "tarefas",
    component: TarefasComponent
  },
  {
    path: "cadastrar-tarefa",
    component: AdicionaTarefaComponent
  },
  {
    path: "responsaveis",
    component: ResponsaveisComponent
  },
  {
    path: "cadastrar-responsavel",
    component: AdicionaResponsavelComponent
  },
  {
    path: "responsaveis/altera-responsavel/:id",
    component: AlteraResponsavelComponent
  },
  {
    path: "tarefas/altera-tarefa/:id",
    component: AlteraTarefaComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
