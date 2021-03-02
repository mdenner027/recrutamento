import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './components/tamplate/header/header.component';
import { FooterComponent } from './components/tamplate/footer/footer.component';
import { NavComponent } from './components/tamplate/nav/nav.component';
import { HomeComponent } from './views/home/home.component';
import { TarefasComponent } from './views/tarefas/tarefas.component';
import { AdicionaTarefaComponent } from './components/tarefas/adiciona-tarefa/adiciona-tarefa.component';
import { AdicionaResponsavelComponent } from './components/responsaveis/adiciona-responsavel/adiciona-responsavel.component';
import { ResponsaveisComponent } from './views/responsaveis/responsaveis.component';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatCardModule } from '@angular/material/card'
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatSnackBarModule } from '@angular/material/snack-bar';

import { HttpClientModule } from "@angular/common/http";
import { LOCALE_ID } from '@angular/core';
import { registerLocaleData } from '@angular/common';
import localePt from '@angular/common/locales/pt';
import { FormsModule } from "@angular/forms";
import { ListaResponsaveisComponent } from './components/responsaveis/lista-responsaveis/lista-responsaveis.component';
import { AlteraResponsavelComponent } from './components/responsaveis/altera-responsavel/altera-responsavel.component';
import { FilterTarefaComponent } from './components/tarefas/filter-tarefa/filter-tarefa.component';
import { ListaTarefasComponent } from './components/tarefas/lista-tarefas/lista-tarefas.component';
import { AlteraTarefaComponent } from './components/tarefas/altera-tarefa/altera-tarefa.component';

registerLocaleData(localePt, 'pt-BR');

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    HomeComponent,
    TarefasComponent,
    AdicionaTarefaComponent,
    AdicionaResponsavelComponent,
    ResponsaveisComponent,
    ListaResponsaveisComponent,
    AlteraResponsavelComponent,
    FilterTarefaComponent,
    ListaTarefasComponent,
    AlteraTarefaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatCardModule,
    MatTableModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatGridListModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatExpansionModule,
    MatSnackBarModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    { provide: LOCALE_ID, useValue: 'pt-BR' }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
