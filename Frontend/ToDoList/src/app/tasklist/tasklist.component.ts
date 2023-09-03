import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-tasklist',
  templateUrl: './tasklist.component.html',
  styleUrls: ['./tasklist.component.css']
})
export class TasklistComponent {
  @Input() data: any;
  title!: string;
  lstOfTask!: any;

  ngOnInit() {
    this.title = this.data.label;
    console.log(this.data);
    this.lstOfTask = this.data.lstOfTask;
  }
}

