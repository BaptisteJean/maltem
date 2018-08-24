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
  newmn: string;
  isTitle= false;
  isDirector = false;
  isreleaseDate = false;
  isTypes = false;

  constructor(
    private router: Router,
    private movieSevice: MovieService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.getCurrentMovie();
  }

  createMovie(movie: Movie): void {

    if(movie.title == null || movie.title.length == 0){
      this.isTitle = true;
    } else this.isTitle = false;
    if(movie.director  == null || movie.director.length == 0){
      this.isDirector = true;
    } else this.isDirector = false;
    if(movie.releaseDate  == null || movie.releaseDate.length == 0){
      this.isreleaseDate = true;
    } else this.isreleaseDate = false;
    if(movie.type  == null || movie.type.length == 0){
      this.isTypes = true;
    } else this.isTypes = false;

    if(!this.isTitle && !this.isDirector && !this.isreleaseDate && !this.isTypes){
      var d = new Date(movie.releaseDate);
      var dt = d.getDate() < 10 ? "0"+d.getDate() : d.getDate();
      var mn = d.getMonth();
      mn++;
      this.newmn = mn < 10 ? "0"+mn.toString() : mn.toString();
      var yy = d.getFullYear();
      var dateC = dt+"/"+this.newmn+"/"+yy;
      movie.releaseDate = dateC;
      this.movieSevice.createMovie(movie)
        .subscribe( data => {
          this.movie = new Movie();
          alert("movie created successfully.");
        });
    }

  }

  getCurrentMovie():void {
      const sub = this.route.params.subscribe(params => {
      this.id = params['id'];
        console.log(this.id);
      if(this.id){
        this.movieSevice.getMovieById(this.id)
          .subscribe( data => {
            this.movie = data;
            console.log(data);
          });
      }
    });
  }

  updateMovie(id, movie): void{
    if(movie.title == null || movie.title.length == 0){
      this.isTitle = true;
    } else this.isTitle = false;
    if(movie.director  == null || movie.director.length == 0){
      this.isDirector = true;
    } else this.isDirector = false;
    if(movie.releaseDate  == null || movie.releaseDate.length == 0){
      this.isreleaseDate = true;
    } else this.isreleaseDate = false;
    if(movie.type  == null || movie.type.length == 0){
      this.isTypes = true;
    } else this.isTypes = false;

    if(!this.isTitle && !this.isDirector && !this.isreleaseDate && !this.isTypes){
      var d = new Date(movie.releaseDate);
      var dt = d.getDate() < 10 ? "0"+d.getDate() : d.getDate();
      var mn = d.getMonth();
      mn++;
      this.newmn = mn < 10 ? "0"+mn.toString() : mn.toString();
      var yy = d.getFullYear();
      var dateC = dt+"/"+this.newmn+"/"+yy;
      movie.releaseDate = dateC;
      this.movieSevice.updateMovie(id, movie)
        .subscribe( data => {
          alert("movie updated successfully.");
        });
    }

    }

}
