import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { MovieComponent } from './movie/movie.component';
import {AddMovieComponent} from './add-movie/add-movie.component';
import {HomePageComponent} from './home-page/home-page.component';

const routes: Routes = [
  { path: 'movie', component: MovieComponent },
  { path: 'add', component: AddMovieComponent },
  { path: 'update/:id', component: AddMovieComponent },
  { path: 'home', component: HomePageComponent }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
