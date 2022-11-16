import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {OAuthService} from "angular-oauth2-oidc";

@Component({
  selector: 'app-table-list',
  templateUrl: './table-list.component.html',
  styleUrls: ['./table-list.component.css']
})
export class TableListComponent implements OnInit {

  dataList: any[];
  dataKeys: string[];

  constructor(private activatedRoute: ActivatedRoute,
              private oauth2Service:OAuthService) {
  }

  ngOnInit() {
    this.dataList = this.activatedRoute.snapshot.data.list;
    this.dataKeys = this.activatedRoute.snapshot.data.keys;
  }

  login() {
    this.oauth2Service.initCodeFlow();
  }
}
