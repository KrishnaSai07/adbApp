import { Component, OnInit } from '@angular/core';
import { Schedule } from '../Schedule.model';

@Component({
  selector: 'app-schedule-base',
  templateUrl: './schedule-base.component.html',
  styleUrls: ['./schedule-base.component.css']
})
export class ScheduleBaseComponent implements OnInit {

  valida: boolean;
  valids: boolean;
  sched: Schedule [];

  constructor() {
    this.valida = false;
    this.valids = false;
    this.sched = [
      new Schedule('harry', 'Pearl', 'Retro Meeting', '29th June 2018', 'Important', '5 PM')
    ];
   }
   addNewRecord(schedi: Schedule): void{
    this.sched.push(schedi);
}

  add(): void {
    this.valida = true;
    this.valids = false;

  }
  show(): void {
    this.valids = true;
    this.valida = false;
  }

  ngOnInit() {
  }

}
