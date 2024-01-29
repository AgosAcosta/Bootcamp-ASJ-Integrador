import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ConditionAfipService {
  constructor(private http: HttpClient) {}
  private url = 'http://localhost:8080/conditionAfip';

  public getConditionAfip(): Observable<any> {
    return this.http.get(this.url);
  }
}
