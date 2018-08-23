import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Movie } from '../movie/movie.model';
import { MovieService } from '../movie/movie.service';

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.css']
})
export class AddMovieComponent implements OnInit {

  movie: Movie = new Movie();

  constructor(private router: Router, private movieSevice: MovieService) { }

  ngOnInit() {

  }

  //createMovie(): void {
  //  this.movieSevice.createMovie(this.movie)
  //    .subscribe( data => {
  //      alert("movie created successfully.");
  //    });
  //
  //}
}
