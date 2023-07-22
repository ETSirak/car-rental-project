import { Component } from '@angular/core';
import {carsPageUrl, clientPageUrl, homePageUrl, loginPageUrl} from "../../models/links";

@Component({
  selector: 'app-navigtion-bar',
  templateUrl: './navigtion-bar.component.html',
  styleUrls: ['./navigtion-bar.component.css']
})
export class NavigtionBarComponent {

  protected readonly homePageUrl = homePageUrl;
  protected readonly clientPageUrl = clientPageUrl;
    protected readonly loginPageUrl = loginPageUrl;
    protected readonly carsPageUrl = carsPageUrl;
}
