import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UbicationService {
  constructor(private http: HttpClient) {}

  private URL = 'http://localhost:8080/ubication';

  public getListCountries(): Observable<any> {
    return this.http.get(this.URL);
  }

  public getListProvincesByCountry(id: number): Observable<any> {
    return this.http.get(`${this.URL}/${id}/provinces`);
  }
}
