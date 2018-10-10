export class Schedule
{   name: string;
    venue: string;
    descript: string;
    date: string;
    status: string;
    time: string;

    constructor(name: string, venue: string, descript: string, date: string, status: string , time: string)
    {   this.name = name;
        this.venue = venue;
        this.descript = descript;
        this.date = date;
        this.status = status;
        this.time = time;
    }
}