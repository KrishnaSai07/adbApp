import { Component, OnInit , Output , EventEmitter} from '@angular/core';
import { Schedule } from '../Schedule.model';

@Component({
  selector: 'app-schedule-entry',
  templateUrl: './schedule-entry.component.html',
  styleUrls: ['./schedule-entry.component.css']
})
export class ScheduleEntryComponent implements OnInit {


  validn: boolean;
  validi: boolean;

  constructor()  {
        this.dataentry = new EventEmitter();
        this.validi = false;
        this.validn = false;
  }
  @Output() dataentry: EventEmitter<Schedule>;

  savei(namei: HTMLInputElement, venuei: HTMLInputElement, descipti: HTMLInputElement, datei: HTMLInputElement, statusi: HTMLInputElement,timei: HTMLInputElement)
{  
    this.dataentry.emit(new Schedule(namei.value, venuei.value, descipti.value, datei.value, statusi.value, timei.value));
    namei.value = "";
    venuei.value = "";
    descipti.value = "";
    datei.value = "";
        timei.value = "";

  }
  saven(name: HTMLInputElement, venue: HTMLInputElement, descipt: HTMLInputElement, date: HTMLInputElement, status: HTMLInputElement ,time:HTMLInputElement)
{  
    this.dataentry.emit(new Schedule(name.value, venue.value, descipt.value, date.value, status.value, time.value));
    name.value = "";
    venue.value = "";
    descipt.value = "";
    date.value = "";
     time.value = "";

  }
  norm():void{
    this.validn = true;
    this.validi = false;

  }
  Imp(): void{
    this.validn = false;
    this.validi = true;
  }

  ngOnInit() {
  }

}
