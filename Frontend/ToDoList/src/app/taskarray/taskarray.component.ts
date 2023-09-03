import { Component } from '@angular/core';

@Component({
  selector: 'app-taskarray',
  templateUrl: './taskarray.component.html',
  styleUrls: ['./taskarray.component.css']
})
export class TaskarrayComponent {
  lstOfTaskList: any;

  ngOnInit() {
    fetch("http://localhost:8080/user/1")
      .then((response) => response.json())
      .then((json) => this.lstOfTaskList = json['lstOfTaskList']);

    
  }
}
