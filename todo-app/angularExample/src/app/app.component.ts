import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'angularExample';
  temp: number = 1;
  yes: boolean = true;
  name = "Styoan";
  showItem = false;

  public test1(param: any = 'lala') {
    console.log(param);
    return "function result";
  }

  public onClick() {
    console.log(this.name);
    console.log('On click');
    this.showItem = true;
  }

  public inputEvent(event: any) {
    console.log(event.target.value);
    this.name = event.target.value;
  }

  public hide() {
    this.showItem = false;
  }
}
