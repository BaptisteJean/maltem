import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Movie } from './movie.model';
import { MovieService } from './movie.service';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {

  movies: Movie[];

  constructor(private router: Router, private movieService: MovieService) { }

  ngOnInit() {
    this.movieService.getMovies()
      .subscribe( data => {
        this.movies = data;
      });
  }

  deleteMovie(id: number): void {
    console.log(id);
    this.movieService.deleteMovie(id)
      .subscribe( data => {
        this.ngOnInit();

      })
  }

}
