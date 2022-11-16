import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs';
import {TableListService} from './table-list.service';

@Injectable({providedIn: 'root'})
export class TableListResolver implements Resolve<Object> {

  constructor(private service: TableListService) {
  }

  resolve(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<any> | Promise<any> | any {
    return this.service.getRows(route.data.url);
  }
}
