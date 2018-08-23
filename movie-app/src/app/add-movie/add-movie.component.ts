import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

import { Movie } from '../movie/movie.model';
import { MovieService } from '../movie/movie.service';

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.css']
})
export class AddMovieComponent implements OnInit {

  movie: Movie = new Movie();
  id: number;

  constructor(
    private router: Router,
    private movieSevice: MovieService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.getCurrentMovie();
  }

  createMovie(movie: Movie): void {
    this.movieSevice.createMovie(movie)
      .subscribe( data => {
        alert("movie created successfully.");
      });

  }

  getCurrentMovie():void {
      const sub = this.route.params.subscribe(params => {
      this.id = params['id'];
        console.log(this.id);
      if(this.id){
        console.log("toto");
        this.movieSevice.getMovieById(this.id)
          .subscribe( data => {
            this.movie = data;
            console.log(data);
          });
      }
    });
  }

  updateMovie(id, movie): void{
      this.movieSevice.updateMovie(id, movie)
        .subscribe( data => {
          alert("movie updated successfully.");
        });

    }

}
