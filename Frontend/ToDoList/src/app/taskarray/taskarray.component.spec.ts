import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskarrayComponent } from './taskarray.component';

describe('TaskarrayComponent', () => {
  let component: TaskarrayComponent;
  let fixture: ComponentFixture<TaskarrayComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TaskarrayComponent]
    });
    fixture = TestBed.createComponent(TaskarrayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
