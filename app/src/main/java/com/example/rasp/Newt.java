package com.example.rasp;

public class Newt {
    public String id, Week, Day, Time, podgrup,prep,cab,para,kurs,grup,predmet;

    public Newt() {
    }

    public Newt(String id,String para, String week, String day, String time,String podgrup,String prep,String cab,String kurs,String grup,String predmet) {
        this.id = id;
        this.Week = week;
        this.Day = day;
        this.Time = time;
        this.podgrup = podgrup;
        this.prep = prep;
        this.cab = cab;
        this.para = para;
        //this.uidd = uidd;
        this.grup = grup;
        this.kurs = kurs;
        this.predmet = predmet;
    }
}
