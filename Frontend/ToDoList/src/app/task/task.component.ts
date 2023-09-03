import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent {
  @Input() data: any;
  label!: String;

  ngOnInit() {
    this.label = this.data.label;
  }
}
