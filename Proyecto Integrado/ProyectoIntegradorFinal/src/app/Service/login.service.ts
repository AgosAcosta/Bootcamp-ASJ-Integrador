import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Login } from '../Models/login';

const LOGIN_STATUS_KEY = 'isLoggedIn';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private URL = 'http://localhost:8080/login';

  private loginSubject: Subject<boolean> = new Subject<boolean>();

  public isLogedIn$: Observable<boolean> = this.loginSubject.asObservable();

  public setLogin(success: boolean) {
    this.loginSubject.next(success);
  }
  
  constructor(private http: HttpClient) {}

  public checkLogin(login: Login): Observable<any> {
    return this.http.post(this.URL, login);
  }

  public setLoggedIn(value: boolean): void {
    localStorage.setItem(LOGIN_STATUS_KEY, value.toString());
  }

  public isLoggedIn(): boolean {
    return localStorage.getItem(LOGIN_STATUS_KEY) === 'true';
  }
}
