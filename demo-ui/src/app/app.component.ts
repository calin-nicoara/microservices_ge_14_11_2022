import {Component} from '@angular/core';
import {OAuthService} from "angular-oauth2-oidc";


@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {

    constructor(
        private oauthService: OAuthService
    ) {
        this.oauthService.configure({
            issuer: 'http://localhost/realms/spring-boot-test',
            redirectUri: window.location.origin,
            clientId: 'web-app',
            responseType: 'code',
            strictDiscoveryDocumentValidation: false,
            scope: 'openid profile email offline_access'
        });

        // this.oauthService.initCodeFlow();

        this.oauthService.loadDiscoveryDocumentAndLogin();
        this.oauthService.setupAutomaticSilentRefresh();
    }
}
