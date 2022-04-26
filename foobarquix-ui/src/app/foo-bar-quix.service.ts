import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {share, take} from 'rxjs/operators';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FooBarQuixService {

  constructor(private httpClient: HttpClient) { }

  convertNumber(inputNumber: number): Observable<ResultDto> {
    return this.httpClient.get<ResultDto>('foo-bar-quix/' + inputNumber).pipe(share());
  }

}

export class ResultDto {
  result: string;
}
