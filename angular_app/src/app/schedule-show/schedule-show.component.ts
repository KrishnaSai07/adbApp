import { Component, OnInit, Input } from '@angular/core';
import {Schedule} from '../Schedule.model';
@Component({
  selector: 'app-schedule-show',
  templateUrl: './schedule-show.component.html',
  styleUrls: ['./schedule-show.component.css']
})
export class ScheduleShowComponent implements OnInit {

  validv: boolean;
  validd: boolean;
  checkd: string;
  redn:boolean;
  redc: boolean;
  constructor() { 
    this.validd = false;
    this.validv = false;
    this.redn= false;
  }
  @Input() dummy_sched: Schedule[];
  dummy_sched1: Schedule[];
 
  

  all(): void {
     this.validv = true;
     this.validd = false;
     
    }
     
  
  date(): void {
    this.validd = true;
    this.validv = false;
    this.checkd = "";
  }
  search(search: HTMLInputElement)
  {
    let i: number;
    let j: number;
    j = 0;
    this.checkd = search.value;
    for(i = 0; i < this.dummy_sched.length; i++)
    {
      if(this.checkd === this.dummy_sched[i].date)
      {
           console.log("heyy");
           this.dummy_sched1[j] = new Schedule(this.dummy_sched[i].name, this.dummy_sched[i].venue,this.dummy_sched[i].descript,this.dummy_sched[i].date,this.dummy_sched[i].status,this.dummy_sched[i].time);
           j++;
      }
    }
      }
  ngOnInit() {
  }

}
