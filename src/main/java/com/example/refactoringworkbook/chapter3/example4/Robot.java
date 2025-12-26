package com.example.refactoringworkbook.chapter3.example4;

import java.io.StringWriter;

public class Robot {
    Machine location;
    String bin;

    public Robot() {}

    public Machine location() {return location;}
    public void moveTo(Machine location) {this.location = location;}

    public void pick() {this.bin = location.take();}
    public String bin() {return bin;}

    public void release() {
        location.put(bin);
        bin = null;
    }

    public String report() {
        StringWriter out = new StringWriter();
        out.write("Robot");
        if (this.location != null)
            out.write(" location=" + this.location.name());

        if (this.bin != null)
            out.write(" bin=" + this.bin);

        return out.toString();
    }
}
