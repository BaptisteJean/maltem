import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Movie } from './movie.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class MovieService {

  constructor(private http:HttpClient) {}

  private userUrl = 'http://localhost:8080/api/';

  public getMovies() {
    return this.http.get<Movie[]>(this.userUrl+"allMovies");
  }

  public deleteMovie(movieId) {
    return this.http.delete(this.userUrl + "deleteMovie/"+ movieId);
  }

  public createMovie(movie) {
    return this.http.post<Movie>(this.userUrl+"addMovie", movie);
  }

  public getMovieById(movieId){
    return this.http.get<Movie>(this.userUrl+"findMovieById/"+movieId);
  }

  public updateMovie(movieId, movie){
    return this.http.put<Movie>(this.userUrl+"updateMovie/"+movieId,movie);
  }

}
