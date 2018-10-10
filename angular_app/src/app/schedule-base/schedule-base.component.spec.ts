import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ScheduleBaseComponent } from './schedule-base.component';

describe('ScheduleBaseComponent', () => {
  let component: ScheduleBaseComponent;
  let fixture: ComponentFixture<ScheduleBaseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ScheduleBaseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ScheduleBaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
