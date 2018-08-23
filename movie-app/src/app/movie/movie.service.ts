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

  public deleteMovie(movie) {
    return this.http.delete(this.userUrl + "/"+ movie.id);
  }

  //public createMovie(movie) {
  //  return this.http.post<Movie>(this.userUrl, movie);
  //}

}
