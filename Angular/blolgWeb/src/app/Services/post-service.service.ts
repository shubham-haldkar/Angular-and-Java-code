import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASIC_URL = 'http://localhost:8080/' ;

@Injectable({
  providedIn: 'root'
})
export class PostServiceService {

  constructor( private http:HttpClient ) { }

  createNewPost(data:any):Observable<any>{
    console.log(data);
    
    return this.http.post(BASIC_URL + 'api/posts/' , data) ;
  }
}
