import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({providedIn: 'root'})
export class TableListService {

  constructor(private httpClient: HttpClient) {
  }

  getRows(url: string): Observable<any> {
    // const headers = new HttpHeaders({
    //   "Authorization": "Basic YWRtaW46YWRtaW4="
    // });

    // return this.httpClient.get(url, {headers: headers})
    return this.httpClient.get(url)
  }
}
