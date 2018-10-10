import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { ScheduleBaseComponent } from './schedule-base/schedule-base.component';
import { ScheduleEntryComponent } from './schedule-entry/schedule-entry.component';
import { ScheduleShowComponent } from './schedule-show/schedule-show.component';

@NgModule({
  declarations: [
    AppComponent,
    ScheduleBaseComponent,
    ScheduleEntryComponent,
    ScheduleShowComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
