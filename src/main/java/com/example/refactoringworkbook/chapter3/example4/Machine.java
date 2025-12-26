package com.example.refactoringworkbook.chapter3.example4;

import java.io.StringWriter;

public class Machine {
    String name;
    String location;
    String bin;

    public Machine(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String take() {
        String result = bin;
        bin = null;
        return result;
    }

    public String bin() {
        return bin;
    }

    public void put(String bin) {
        this.bin = bin;
    }

    public String name() {return name;}

    public String report() {
        StringWriter out = new StringWriter();
        out.write("Machine " + this.name);

        if (this.bin != null)
            out.write(" bin=" + this.bin);

        out.write("\n");
        return out.toString();
    }
}
